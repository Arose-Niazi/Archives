import java.io.*;
import java.util.Scanner;
public class DirReaderTest {

	public static void main(String args[]) throws IOException 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a directory path (../ to go a folder back from current path) (/ to goto base of directory) : ");
		String DirectoryPath = input.nextLine();
		System.out.print("Please enter file name : ");
		String FileName = input.nextLine();
		DirReader First = new DirReader(DirectoryPath);
		System.out.println("\n\n\tFiles and Folders: "+First.CheckDir(DirectoryPath,0));
		First.StoreToFile(FileName+".txt");
	}
}