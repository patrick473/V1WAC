package les1.practicum5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStream;

public class Server {
  public static void main(String[] arg) throws Exception {
    ServerSocket ss = new ServerSocket(4711);
    while (true) {
    	new MyServlet(ss.accept()).start();
    }
  }
}