package WebApplication.ServletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloWorldServlet extends HttpServlet{

 private String title;
 private String name;

    public void init() throws ServletException 
    {              
       title = "Välkommen ";  
    }

   public void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, 
      IOException{ 
       name = request.getParameter("first_name");
       name += " " + request.getParameter("last_name");
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();  
      out.println("<HTML><HEAD><TITLE>"+ title + "</TITLE></HEAD><BODY><TABLE>");
      out.println("<BODY><H1 align = \"center\">" + title + name+  "</H1></BODY></HTML>");
   } 
}