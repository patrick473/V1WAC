package practicum1;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;

class Server {
  public static void main(String[] arg) throws Exception {
	System.out.println("server started");
    ServerSocket ss = new ServerSocket(4711);
    Socket s = ss.accept();
    InputStream is = s.getInputStream();

    int c = is.read();
    while (c != -1) {
      System.out.print((char) c);
      c = is.read();
    } 
   
    s.close();
    ss.close();
  }
}