package nl.hu.v1wac.firstapp.servlets;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/DynamicServlet.do")

public class DynamicServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException {
 String number1 = req.getParameter("number1");
 String number2 = req.getParameter("number2");
 System.out.println(number2);
 System.out.println(number1);
 Integer number3;
 
 if(req.getParameter("operator1")!= null){
	 number3 = Integer.parseInt(number2) + Integer.parseInt(number1);
	 System.out.println("rip");
 }
 else if(req.getParameter("operator2")!= null){
	 number3 = Integer.parseInt(number2) - Integer.parseInt(number1);
 }
 else if(req.getParameter("operator3")!= null){
	 number3 = Integer.parseInt(number2) * Integer.parseInt(number1);
	 
 }
 else if(req.getParameter("operator4")!= null){
	 number3 = Integer.parseInt(number2) / Integer.parseInt(number1);
 }
 else{number3= Integer.parseInt(number1);}
 System.out.println(number3);
 PrintWriter out = resp.getWriter();
 resp.setContentType("text/html");
 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println(" <title>Dynamic Example</title>");
 out.println(" <body>");
 out.println(" <h2>het nummer is " + number3 + "!</h2>");
 out.println(" </body>");
 out.println("</html>");
 }
}