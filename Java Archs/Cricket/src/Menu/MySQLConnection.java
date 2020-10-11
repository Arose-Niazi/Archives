package Menu;

import MISC.DatabaseErrors;
import Player.StatsSaveLoad;

import java.sql.*;

public class MySQLConnection {

    private static Connection con;
    private static MySQLConnection currentObj;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException ex) {
            new DatabaseErrors(null,"Error: No MYSQL Driver found \n" + ex);
        }
    }

    public MySQLConnection()
    {
        currentObj=this;
        try {
            con = DriverManager.getConnection("jdbc:mysql://149.202.65.49:3306/Sasuke","Sasuke","WEbXBGjVUdlHmXG7");
        }
        catch(Exception e){ new DatabaseErrors(null,e.toString());}
    }

    public void endConnection()
    {
        try {
            new StatsSaveLoad(main_menu.getMain().getPlayer()).saveStats();
            con.close();
        }
        catch(SQLException e)
        {
            new DatabaseErrors(null,e.toString());
        }

    }

    public static Connection getConnection()
    {
        return con;
    }
    public static MySQLConnection getCurrentObj()
    {
        return currentObj;
    }
}