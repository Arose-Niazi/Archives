import java.io.*;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;

import java.util.ArrayList;

class Project
{	
	private static String fileName;
	private static Scanner input ;
	private static String sid;
	private static String fName;
	private static String lName;
	private static int age;
	private static double cgpa;
	private static String cnic;
	private static String email;
	private static BufferedReader reader;
	private static BufferedReader reader1;
	private static BufferedWriter wStudentdata;
	private static BufferedWriter wError;
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static ArrayList<Student> studentData = new ArrayList<Student>();
	
	




	
	
	
	public static void main(String[] args) throws IOException
	{		
			
			fileName= args[0];
			openFile(fileName);
			readFile();
			check();			
			closeFile();	

			openFileStudentData();
			readStudentData();
			closeFileStudentData();
			
			System.out.printf("there are %d Students in the list\n\n\n",studentData.size());
			System.out.print("Here is Unsorted List \n[");
			for(Student s : studentData )
			{
				System.out.println(s.print());
			}
			System.out.print("]\n");
			
			
			Collections.sort(studentData, new sidComparator());	
			System.out.print("Here is Sorted List by SID \n[");
			for(Student s : studentData )
			{
				System.out.println(s.print());
			}
			System.out.print("]\n");
			
			Collections.sort(studentData, new ageComparator());	
			System.out.print("Here is Sorted List by AGE \n[");
			for(Student s : studentData )
			{
				System.out.println(s.print());
			}
			System.out.print("]\n");
			
			Collections.sort(studentData, new cgpaComparator());	
			System.out.print("Here is Sorted List by CGPA in decending order \n[");
			for(Student s : studentData )
			{
				System.out.println(s.print());
			}
			System.out.print("]\n");
			
			Collections.sort(studentData, new nameComparator());	
			System.out.print("Here is Sorted List by First Name \n[");
			for(Student s : studentData )
			{
				System.out.println(s.print());
			}
			System.out.print("]\n");
			
			
			double totalAge=0;
			double totalCgpa=0;
			int counter =0;
			Iterator<Student> iterator=studentData.iterator();
			while(iterator.hasNext())
			{
				totalAge += studentData.get(counter).getAge();
				totalCgpa += studentData.get(counter).getCgpa();
				counter++;
				iterator.next();
        	}

			System.out.printf("Average Age = %.2f and Average CGPA = %.2f",(totalAge/studentData.size()),(totalCgpa/studentData.size()));		
		
	}


	
		
	
	

	public static void openFile(String fileName)
	{
		String file = fileName; 
		try
		{
			reader = new BufferedReader(new FileReader(fileName));
		}
		catch(IOException ioException)
		{		
			System.err.println("file not found");
			System.exit(1);
		}

	
	}
	
	
	
	
	
	
	private static void readFile() throws IOException
	{
		String line;
		
		while ( (line = reader.readLine()) != null )
		{	
			String[] studentInfo = line.split(",");
			sid = studentInfo[0];
			fName = studentInfo[1];				
			lName = studentInfo[2];
			cnic = studentInfo[3];
			age = Integer.parseInt(studentInfo[4]);
			cgpa = Double.parseDouble(studentInfo[5]);
			email = studentInfo[6];
			
			studentList.add(new Student(sid,fName,lName,cnic,age,cgpa,email));
		}	
					
	}	
	
	
	
	private static void closeFile()
	{
		try
		{
			if(reader!=null)
				reader.close();
		}	
		catch(IOException ioException)
		{		
			System.err.println("file not found");
			System.exit(1);
		}
	}
	
		
	public static void openFileStudentData()
	{
		try
		{
			reader1 = new BufferedReader(new FileReader("StudentData.ser"));
		}
		catch(IOException ioException)
		{		
			System.err.println("file not found");
			System.exit(1);
		}
	}	
	
	public static void readStudentData() throws IOException
	{
		String line;
		
		while ( (line = reader1.readLine()) != null )
		{	
			String[] studentInfo = line.split(" ");
			sid = studentInfo[0];
			fName = studentInfo[1];				
			lName = studentInfo[2];
			cnic = studentInfo[3];
			age = Integer.parseInt(studentInfo[4]);
			cgpa = Double.parseDouble(studentInfo[5]);
			email = studentInfo[6];
			
			studentData.add(new Student(sid,fName,lName,cnic,age,cgpa,email));
		}	
		
		
		
	}	
	
	private static void closeFileStudentData()
	{
		try
		{
			if(reader1!=null)
				reader1.close();
		}	
		catch(IOException ioException)
		{		
			System.err.println("file not found");
			System.exit(1);
		}
	}	
	
	
	
	
	
	
	
	
	




	public static void check() throws IOException
	{
		Pattern p_sid = Pattern.compile("(FA|SP)\\d{2}-(B|M)(SE|CE|BA|CS|AR|PH)-\\d{3}");
		
		Pattern p_fName = Pattern.compile ("[A-Za-z]+");
	
		Pattern p_lName = Pattern.compile("[A-Za-z]+");

		Pattern p_cnic = Pattern.compile("[0-9]{5}-[0-9]{7}-[0-9]{1}");
		
		Pattern p_age = Pattern.compile("[0-9]{2}");
		
		Pattern p_cgpa = Pattern.compile("[0-4].\\d{1,2}");
	
		Pattern p_email = Pattern.compile("(FA|SP)\\d{2}-(B|M)(SE|CS|CE|AR|BA|PH)-\\d{3}(@cuilahore.edu.pk)");
		
		Matcher m_sid,m_fName,m_lName,m_cnic,m_age,m_cgpa,m_email ;
		

		try
		{
			File sf = new File ("StudentData.ser");
			File se = new File ("ErrorMsgs.txt");
			
			if(!sf.exists())
				sf.createNewFile();
				
			if(!se.exists())
				se.createNewFile();
			
			wStudentdata = new BufferedWriter(new FileWriter(sf));
			wError = new BufferedWriter(new FileWriter(se));
		}
		catch(IOException ioException)
		{		
			System.err.println("file not found");
			System.exit(1);
		}
		
	
		for(Student s : studentList)
		{		
			int y=0;	
			m_sid 	 = p_sid.matcher( s.getSid() );
			m_fName	 = p_fName.matcher( s.getFname());
			m_lName  = p_lName.matcher( s.getLname());
			m_cnic   = p_cnic.matcher(s.getCnic());
			m_age    = p_age.matcher(String.valueOf(s.getAge()));
			m_cgpa   = p_cgpa.matcher(String.valueOf(s.getCgpa()));
			m_email  = p_email.matcher(s.getEmail());
			
			if ( m_sid.matches())
			{
				y++;
			}	
			else 
			{
				wError.write("Incorrect SID :");
				wError.write(s.getSid());
				wError.write("\n");
				y++;
				
			}	
				
				
			
			
			if(m_fName.matches())
			{
				y++;
			}	
			else 
			{
				wError.write("Incorrect First Name :");
				wError.write(s.getFname());
				wError.write("\n");
			}
			
			
			
			if(m_lName.matches())
			{
				y++;
			}	
			else 
			{
					wError.write("Incorrect Last Name :");
					wError.write(s.getLname());
					wError.write("\n");

			}
			
						
			if(m_cnic.matches())
			{	
				y++;
			}	
			else 
			{
				wError.write("Incorrect CNIC :");
				wError.write(s.getCnic());
				wError.write("\n");
				
			}
				
			
			
			if(m_age.matches())
			{
				y++;
			}	
			else 
			{
					wError.write("Incorrect Age :");
					wError.write(String.valueOf(s.getAge()));
					wError.write("\n");
					
				
			}
				
			
			
			if(m_cgpa.matches())
			{
	
				y++;
			}	
			else 
			{
				
					wError.write("Incorrect CGPA :");
					wError.write(String.valueOf(s.getCgpa()));
					wError.write("\n");
				
			}
			
			
			if(m_email.matches())
			{
				y++;
			}	
			else 
			{

				wError.write("Incorrect Email :");
				wError.write(s.getEmail());
				wError.write("\n");
				
				
			}
			if(y==7)
			{

				wStudentdata.write(s.toString());
				wStudentdata.write("\n");
				
			}	
			else
			{	
				wError.write("Line "+s.toString()+" contains wrong data");
				wError.write("\n");
				
			}
		
		}
		if(wError!=null)
			wError.close();
		if(wStudentdata!=null)
			wStudentdata.close();

	}
	
	
	
	
	
	
	
			
		
}












class sidComparator implements Comparator<Student>
{		
	@Override
	public int compare(Student s1,Student s2)
	{
		return s1.getSid().compareTo((s2.getSid()));
	}

}

class ageComparator implements Comparator<Student>
{
	@Override
	public int compare(Student s1,Student s2)
	{
		return String.valueOf(s1.getAge()).compareTo(String.valueOf((s2.getSid())));
	}		
	
}

class cgpaComparator implements Comparator<Student>
{
	@Override
	public int compare(Student s1,Student s2)
	{
		return String.valueOf(s2.getCgpa()).compareTo(String.valueOf((s1.getCgpa())));
	}		
	
}

class nameComparator implements Comparator<Student>
{		
	@Override
	public int compare(Student s1,Student s2)
	{
		return s1.getFname().compareTo((s2.getFname()));
	}

}
	









class Student
{
	private String fName;
	private String lName;
	private String cnic; 
	private String sid;
	private String email;
	private int age;
	private double cgpa;
	
	public Student(String sid,String fName,String lName,String cnic,int age,double cgpa,String email)
	{
		this.sid=sid;
		this.fName=fName;
		this.lName=lName;
		this.cnic=cnic;
		this.age=age;
		this.cgpa=cgpa;
		this.email=email;	
	}
	public String getSid()
	{
		return sid;
	}
	
	public String getFname()
	{
		return fName;
	}

	public String getLname()
	{
		return lName;
	}
	
	public String getCnic()
	{
		return cnic;
	}
	public int getAge()
	{
		return age;
	}
	public double getCgpa()
	{
		return cgpa;
	}	
		
	public String getEmail()
	{
		return email;
	}
	public String toString()
	{
		return String.format("%s %s %s %s %d %.2f %s",getSid(),getFname(),getLname(),getCnic(),getAge(),getCgpa(),getEmail());
	}	
	public String print()
	{
		return String.format("SID: %s, fName: %8s, lName: %8s, Cnic: %s, Age: %2d, CGPA %.2f",getSid(),getFname(),getLname(),getCnic(),getAge(),getCgpa());
	}
		
	
}	
	