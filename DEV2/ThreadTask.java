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

public class ThreadTask implements Runnable {

	String clientInput="";

  Socket clientSocket;
	
	public void run() {

        try {
        	 int port = 05;

        	  ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("waiting for clients...");
            
                 Socket socket = serverSocket.accept();
                 System.out.println("commands available : get hada.txt - list folder - quit " );

                 System.out.println("server listing on port"+ port);
                File dir  = new File("C:\\\\folder");
                File[] liste = dir.listFiles();
                
                
                   BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                  clientInput = input.readLine();
                  PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                  
                  
                  
                  if(clientInput.equals("quit")){
                     
                      System.out.println("fin de session");

                  }
                  else  if(clientInput.equals("get hada.txt")){
                      try
                         {
                         
                    	  File dir1  = new File("C:\\\\\\\\folder\\\\hada.txt");

                           FileInputStream file = new FileInputStream(dir1);  
                     Scanner sc = new Scanner(file);  
                           
                         
                           while(sc.hasNextLine())
                           {
                             System.out.println(sc.nextLine());
                             String msg = sc.nextLine();
                             out.println(new String(msg));
                           }
                           sc.close();    
                         }
                         catch(IOException e)
                         {
                           e.printStackTrace();
                         }
                      }

                  
                        
                      if(clientInput.equals("list folder")){
                    	  try {
							if(!dir.exists()) {
								System.out.println("file not existant");
							}else {

								for(File s : liste){
							        if(s.isFile())
							        { 
							        	
							        	out.println(new String("Nom du fichier "+s.getName()));
							        	
							        	   System.out.println("Nom du fichier  : "+ s.getName()); 
							          
							        } 
							        else if(s.isDirectory())
							        {
							        	out.println(new String("Nom du répertoire  :"+s.getName()));
							        	 System.out.println("Nom du répertoire  : "+ s.getName()); 
							        }
							}
							}
						} catch (Exception e) {
							
							e.printStackTrace();
						}  
                        	input.close();
                            out.close();
                            socket.close();
                      }
                        	
                       

               
        } catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
	}
}
