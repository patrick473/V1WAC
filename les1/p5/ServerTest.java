package les1.practicum5;

import java.io.*;
import java.net.Socket;
public class ServerTest {
 private static String host = "localhost";
 private static int port = 4711;
 private static int noThreads = 120;

 private static int correctResponses = 0;
 private synchronized static void increaseCorrectResponses() {correctResponses++;}
 public static void main(String[] args) throws InterruptedException {
 TestThread[] myThreads = new TestThread[noThreads];
 long starttime = System.currentTimeMillis();
 for (int i = 0; i < noThreads; i++) {
 myThreads[i] = new TestThread("Thread " + i);
 myThreads[i].start();
 }
 for (TestThread tt : myThreads) tt.join();
 long endtime = System.currentTimeMillis();
 System.out.println("Time elapsed (millis): " + (endtime - starttime));
 System.out.println("Correct responses: " + correctResponses);
 }
 static class TestThread extends Thread {
 public TestThread(String name) { super(name); }
 public void run() {
 String threadName = Thread.currentThread().getName();
 String result = String.format("Response for %s: ", threadName);
 try {
 Socket s = new Socket(host, port);
 OutputStream os = s.getOutputStream();
 // Sending a second enter (and thus an empty line) to emulate "End Of Request"!
 os.write(String.format("Hi server, this is %s!\r\n\r\n", threadName).getBytes());
 os.flush();
 InputStream is = s.getInputStream();
 StringBuilder sb = new StringBuilder();
 for (int c = -1; (c = is.read()) != -1; sb.append((char) c));
 result += (sb.toString().contains("SUCCES") ? "OK" : "NOT OK");
 if (result.contains("OK")) increaseCorrectResponses();
 s.close();
 } catch (Exception e) { result += ("FAILED: " + e.getMessage()); }
 System.out.println(result);
 }
 }
}