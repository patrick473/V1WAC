package les1.practicum4;

import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;

class Client {
  public static void main(String[] arg) throws Exception {
    Socket s = new Socket("localhost", 4711);
    OutputStream os = s.getOutputStream();
    PrintWriter pw = new PrintWriter(os,true);
    Scanner sc = new Scanner(System.in);
	System.out.print("tekst versturen: ");
    String txt = sc.nextLine();
    while (!txt.equals("stop")) {
    	pw.println(txt);
    	System.out.print("tekst versturen: ");
    	txt = sc.nextLine();
    }
    sc.close();
    pw.close();
    s.close();
  }
}