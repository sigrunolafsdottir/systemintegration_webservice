package WebApplication.HolaAmigosServlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HolaAmigos extends HttpServlet{
    
    DAO d = new DAO();
    String title;
    String name;
    
      public void init() throws ServletException 
    {              
       title = "Välkommen till telefonboken";  
    }
      
    public void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, 
      IOException{ 
      name = request.getParameter("name");
      String person = d.getPersonByNameAsString(name);
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();  
      out.println("<HTML><HEAD><TITLE>"+ title + "</TITLE></HEAD>");
      if (person != null){
        out.println("<BODY><H1 align = \"center\">" + person.toString()+  "</H1>");
      }
      else{
        out.println("<BODY><H1 align = \"center\">" + " The person could not be found" +  "</H1>");
      }
      out.println(this.getServletContext().getServerInfo() + "</BODY></HTML>");
   } 
   
   public void doPost(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, 
      IOException{ 
       doGet(request, response);
   } 
 
}

