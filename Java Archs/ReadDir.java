import java.io.File;
public class ReadDir {

	public static void main(String[] args) 
	{
		File file = null;
		File file2 = null;
		String[] paths;
		String[] paths2;
	
		try 
		{      
			// create new file object
			file = new File("../");

			// array of files and directory
			paths = file.list();

			// for each name in the path array
			for(String path:paths) {
				// prints filename and directory name
				System.out.println(path);
				file2 = new File("../"+path);
				
				if(file2.isDirectory())
				{
					
					System.out.println("File --> "+"../"+ path);
					paths2 = file2.list();
					for(String path2:paths2) {
						System.out.println("\t"+path2);
					}
				}
			}
		} 
		catch (Exception e) 
		{
			// if any error occurs
			e.printStackTrace();
		}	
	}
}