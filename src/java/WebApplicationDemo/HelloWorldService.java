 package WebApplicationDemo;

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/HelloWorldService") 

public class HelloWorldService {  
   @GET 
   @Path("/hi") 
   @Produces(MediaType.TEXT_PLAIN) 
   public String getHelloWorld(){ 
      return "Hello World, brought to you by HelloWorldService"; 
   }  
}