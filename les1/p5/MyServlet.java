package les1.practicum5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyServlet extends Thread {
	private Socket socket;
	
	public MyServlet(Socket sock) {
		socket = sock;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
		InputStream is = socket.getInputStream();
	    Scanner sc = new Scanner(is);
	    while (sc.hasNextLine()) {
	    	System.out.println(sc.nextLine());
	    }
	
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    out.println("HTTP/1.1 200 OK\n\nSUCCES");
	    
	    socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
