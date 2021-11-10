package Dev_TP2;


import java.io.*;
import java.util.ArrayList;
import java. util. Scanner;
	public class class2 {

	   public static void main(String [] args) throws ClassNotFoundException {
		   ArrayList<Employee> emps = new ArrayList<>();
		   boolean t=true;
		   Employee e=null;
	   
	      try {
	         FileInputStream fileIn = new FileInputStream("emp.dat");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         while(t){
	        	 e=null;
	                try {
	                    e = (Employee) in.readObject();
	                } catch (EOFException ed) {
	                    break;
	                } catch (ClassNotFoundException eds) {
	                    eds.printStackTrace();
	                }
	                if(e != null) {
	                    emps.add(e);
	                    System.out.println("Deserialized Employee... \n");
	          	      System.out.println("Name is: " + e.name);
	          	      System.out.println("Address : " + e.address);
	          	      System.out.println("SSN: " + e.SSN);
	          	      System.out.println("Number: " + e.number);
	                }
	                else{
	                    t = false;
	                }
	            }
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      }
	
	      
	      try {
			RandomAccessFile raf = new RandomAccessFile("empdirect.dat", "rw");
			
			try {
				raf.seek(0);
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			for(int n=0;n<class1.number;n++) {
			raf.writeUTF(e.name);
			raf.writeUTF(e.address);
			raf.write(e.SSN);
			raf.write(e.number);
			raf.close();
			}
		} 
			catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		} catch (IOException e1) {
				
				e1.printStackTrace();
			}
	   }
	}