package practicum3;

import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;

class Client {
  public static void main(String[] arg) throws Exception {
	String String;
    Socket s = new Socket("145.89.102.92", 4711);
    OutputStream os = s.getOutputStream();
    Scanner sc = new Scanner(System.in);
    PrintWriter pw = new PrintWriter(os, true);
    do{
    	String = sc.nextLine();
    	pw.println(String);
    }
    while(String != "stop");
	pw.close();
	s.close();
  }
}