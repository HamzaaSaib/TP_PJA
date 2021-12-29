package DEV2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;

public class server {
	public static void main(String[] args)
    {
        String clientInput="";
        int port_nbr = 	05 ;
        try {

        	  ServerSocket serverSocket = new ServerSocket(port_nbr);
        	  //create server socket with port and waiting for clients
            System.out.println("server listening on port number "+ port_nbr + ":) ");
             boolean stop = true;
             
              while (stop) {
                 Socket socket = serverSocket.accept();
                // accepting the client
                 System.out.println(" client accepted :) ");

                File dir  = new File("C:\\folder");
                File[] liste = dir.listFiles();
                
              
                   BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // using bufferReader to get the input
                  clientInput = input.readLine();
                // getting the user input
                  PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                        
                  
                  
                  if (clientInput.equals("quit")){
                    	out.println(new String("ending ...... "));
                      // 	out.println("end ");
                      	break ;
             		}
                	
                        		if(clientInput.equals("get hada")){
                        		try
                        	    {
                        	      // Le fichier d'entrée
                        			
                                    File dir1  = new File("C:\\\\folder\\hada.txt");

                        	      FileInputStream file = new FileInputStream(dir1);   
                        	      Scanner sc = new Scanner(file);  
                        	      
                        	      //renvoie true s'il y a une autre ligne à lire
                        	      while(sc.hasNextLine())
                        	      {
                        	        String txt = sc.nextLine();
                        	        out.println(new String(txt));
                        	        System.out.println(sc.nextLine());

                        	      }
                        	      sc.close();    
                        	    }
                        	    catch(IOException e)
                        	    {
                        	      e.printStackTrace();
                        	    }
                        		
                        		

                        	}
                        		 if(clientInput.equals("list folder")){
                                     // testing 
                        			 //   System.out.println("boucle equals...");

                                 	for(File item : liste){
                                         if(item.isFile())
                                         { 
                                         	//PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                                         	// out.println(socket.getOutputStream());
                                         	out.println(new String("Nom du fichier :    "+item.getName()));
                                         	//out.println(new String(clientInput));
                                         	//	    System.out.format("Nom du fichier  : ", item.getName()); 
                                           //   System.out.println(item.getName());
                                         	// System.out.println("boucle fichier...");
                                         } 
                                         else if(item.isDirectory())
                                         {
                                         	out.println(new String("Nom du répertoire  :   "+item.getName()));
                                         	//  System.out.format("Nom du répertoire  : ", item.getName()); 
                                         } 
                                         //   out.println(new String("d"));
                                 } // out.println(new String("end "));
                                 
                          
                               }
                        		 
                        	//     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                // using printwriter to send a message
                  //   out.println(new String(clientInput).toUpperCase());
                // snding the same client input as upper case

                       input.close();
                      out.close();
                      socket.close();
                // closing

            
               }
        } catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
