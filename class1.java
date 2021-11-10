package Dev_TP2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java. util. Scanner;
public class class1 {
static int number;
static int n= 0;
   public static void main(String [] args) {
	   System.out.println("enter number of objects ");
	   Scanner input = new Scanner( System.in );
	  number = input.nextInt();
	
		   
		 
		     
		      try {
		          FileOutputStream fileOut =
		          new FileOutputStream("emp.dat");
		          ObjectOutputStream out = new ObjectOutputStream(fileOut);
		          while (n<number) {
		          Employee e = new Employee();
		      
				   System.out.println("enter name :\n ");
				    e.name = input.next();
				    System.out.println("enter address: \n");
				      e.address = input.next();
				      System.out.println("enter SSN :\n");
				      e.SSN = input.nextInt();
				      System.out.println("enter number:\n ");
				      e.number = input.nextInt(); 
		          out.writeObject(e);
		          n ++ ;
		          System.out.printf("Serialized data is saved succesfuly in emp.dat \n", args);
		          }
		        
		         
		       } catch (IOException i) {
		          i.printStackTrace();
		          
		       }
		        
	   }
    
      
     
}