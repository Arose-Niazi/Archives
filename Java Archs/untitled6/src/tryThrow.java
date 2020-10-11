import java.io.IOException;

public class tryThrow {

    float f = 1F;
    double d = 1.0;
    public static int sum(int x,int y) throws IOException
    {
        throw new IOException("Error ha");
    }

    public static void main(String args[])
    {
        try {
            sum(1,2);
        }
        catch (IOException e)
        {

            System.out.println(e.getMessage() + "Works");
        }
    }
}

