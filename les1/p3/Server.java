package practicum3;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStream;

class Server {
  public static void main(String[] arg) throws Exception {
	System.out.println("server started");
    ServerSocket ss = new ServerSocket(4711);
    Socket s = ss.accept();
    InputStream is = s.getInputStream();

    Scanner scanner = new Scanner(is);
    while(scanner.hasNextLine()){
    System.out.println(scanner.nextLine());
    }
    scanner.close();
    s.close();
    ss.close();
  }
}