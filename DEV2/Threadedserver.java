package DEV2;
import java.io.IOException;
import java.net.ServerSocket;
public class Threadedserver {

		public static void main(String[] args){
			try {
	        	 int port = 05;
				ServerSocket serversocket = new ServerSocket(port);
				while(true) {
				 serversocket.accept();
					Thread t = new Thread();
					t.start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		

		}
}