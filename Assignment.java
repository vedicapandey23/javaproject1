package labassignment3;
import java.util.*;

class Student
{
	public String studentName;
	public String studentId;
	public double studentGrade;
	public String year;
	
	public Student(String studentName, String studentId, double studentGrade, String year) {
		
		this.studentName = studentName;
		this.studentId = studentId;
		this.studentGrade = studentGrade;
		this.year = year;
	}

	public Student(String studentName, String studentId) {
		
		this(studentName,studentId,0.0,null);
	}

	public Student(String studentId) {
		
		this(null,studentId,0.0,null);
	}
	
	  public void display()
	  {
		  System.out.println("Student name: "+studentName);
		  System.out.println("student id: "+studentId);
		  System.out.println("student grade:"+studentGrade);
		  System.out.println("studnet admisssion year : "+year);
		  
	  }
	  
	  public void display(String year)
	  {
		  
		    display();
			//System.out.println("Year is: "+year);	  
		  
	  }
		 
	
}

public class Assignment {

	public static void main(String[] args) {
		
		//System.out.println("hello");
		Student[] student=new Student[3];
		int temp[]=new int[3];
		int temp2=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 to get menu and 0 to exit");
		int ch6=sc.nextInt();
		while(ch6!=0)
		{
			
		System.out.println("Enter 1 for object creation and 2 to display");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			
			int ch=0;
			
			System.out.println("Enter your choice 1 to provide full information, 2 to provide name and id, 3 to provide id");
			
			ch=sc.nextInt();
			
			switch(ch)
			{
			
			case 1:
			
				System.out.println("Enter Complete Details");
				System.out.println("enter student name:");
				String name=sc.next();
				System.out.println("enter student id:");
				String stuid=sc.next();
				System.out.println("enter student grade:");
				double stugrade=sc.nextDouble();
				System.out.println("enter student admiision year:");
				String stuyear=sc.next();
				
				student[temp2]=new Student(name,stuid,stugrade,stuyear);
				temp2++;
				
				break;
				
			
			case 2:
				System.out.println("Enter Name and Id");
				System.out.println("enter student name:");
				String name1=sc.next();
				System.out.println("enter student id:");
				String stuid1=sc.next();
				student[temp2]=new Student(name1,stuid1,0.0,null);
			    temp2++;
				break;
				
			case 3:
				
				System.out.println("Enter Id");
				
				System.out.println("enter student id:");
				String stuid2=sc.next();
				student[temp2]=new Student(null,stuid2,0.0,null);
				temp2++;
				break;
		
				default:
					System.out.println("wrong choice");
		
			}
		}
		
		else if(choice==2)
		{
			System.out.println("enter year to display student information");
			String year=sc.next();
			int j=0;
			//System.out.println(student[j].year);
			for(int i=0;i<student.length;i++)
			{
				
				if((student[i].year).equals(year))
				{
					
					temp[j]=i;
					j++;
				}
				
				
			}
			
			
			
			for(int k=0;k<temp.length;k++)
			{
				student[temp[k]].display(year);
			}
			
			
		}
		}
	}

}
