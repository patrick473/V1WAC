package practicum2;

import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;
class Client {
  public static void main(String[] arg) throws Exception {
    Socket s = new Socket("145.89.118.39", 4711);
    OutputStream os = s.getOutputStream();
    PrintWriter pw = new PrintWriter(os, true);
    pw.write("hallo");
    pw.close();
    s.close();
  }
}
