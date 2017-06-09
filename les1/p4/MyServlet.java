package les1.practicum4;

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
