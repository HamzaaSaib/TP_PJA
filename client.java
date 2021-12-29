package DEV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;


public class client {
	public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String message = "";
        String serverInput="";
        try
        {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            // connecting to server and the ip address depends on the network that we are connected in
            System.out.println("server Ip address: " + serverAddress.getHostAddress());
            Random random = new Random();
    		int identifiantClient = random.nextInt(100);
            System.out.println("welcome client  you are identified by  " + identifiantClient + " :) " );
            System.out.println("commands available : get hada - list folder - quit " );

            boolean stop = true;
            
           
            
            while (stop) {
            	 Socket socket = new Socket(serverAddress, 05);
                 // connecting to server socket
            	 
            	 
            	 
            	 System.out.println("enter your commande  " );
            	 //message=sc.next();
            	 message= sc.nextLine();
                // reading user input
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(message);
                // using printwriter to send the user output
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //  out.println(message);
                
                while (serverInput != null ) {
                	serverInput = input.readLine();
                    // using buffer reader to get and read server input
                	//if (serverInput != "end" ) {
                	System.out.printf(serverInput);
                     
                	  System.out.println(" \n");
                // printing the server input (with uppercase)
                     //	}
                     }
                input.close();
                out.close();
                socket.close();
                // closing connection
            }
        }
        catch(UnknownHostException e1)
        {
            System.out.println("Unknown host exception " + e1.toString());
        }
        catch(IOException e2)
        {
            System.out.println("IOException " + e2.toString());
        }
        catch(IllegalArgumentException e3)
        {
            System.out.println("Illegal Argument Exception " + e3.toString());
        }
        catch(Exception e4)
        {
            System.out.println("Other exceptions " + e4.toString());
        }
    }
}