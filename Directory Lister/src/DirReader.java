import java.io.*;
public class DirReader {

    String BaseString = "";
    public DirReader(String DirectoryPath)
    {

    }
    public int CheckDir(String DirectoryPath,int tabs)
    {
        File f = null;
        int FileCounter = 0;
        int DirectoryCounter = 0;
        try
        {
            f = new File(DirectoryPath);
            String Directory[] = f.list();
            if(!f.exists())
            {
                return DirectoryCounter+FileCounter;
            }
            if(!f.isDirectory())
            {
                FileCounter++;

            }
            else
            {
                DirectoryCounter++;
                for(String path:Directory)
                {
                    for(int i=0; i<tabs; i++) DirSelect.UpdateText("\t");
                    DirSelect.UpdateText(path+"\n");
                    for(int i=0; i<tabs; i++) BaseString += "\t";
                    File f2 = new File(DirectoryPath+"/"+path);;
                    BaseString += path +((f2.isDirectory())?(" *** Folder ***"):"")+ "\r\n";
                    FileCounter+=CheckDir(DirectoryPath+"/"+path,tabs+1);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return DirectoryCounter+FileCounter;
    }
    public void StoreToFile(String FileName) throws IOException
    {
        FileWriter out = null;
        try
        {
            out = new FileWriter(FileName);
            DirSelect.UpdateText("The Char:   "+BaseString.charAt(0));
            for(char c : BaseString.toCharArray())
            {
                out.write((int) c);
            }
        }
        finally
        {
            if (out != null) {
                out.close();
            }
        }
    }
}