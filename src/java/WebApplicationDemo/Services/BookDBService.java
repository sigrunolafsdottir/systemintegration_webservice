package WebApplicationDemo.Services;

import WebApplicationDemo.Models.*;
import WebApplicationDemo.Repository.*;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  

@Path("/BookDBService") 

public class BookDBService {  

    private static BookDaoDB bookDao = new BookDaoDB();
   

   @GET 
   @Path("/books") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<Book> getBooks(){ 
      return bookDao.getAllBooks();
   }  
   
   @GET 
   @Path("/booksJSON") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<Book> getBooksJSON(){ 
      return bookDao.getAllBooks();
   }  
   
   @GET 
   @Path("/booksHTML") 
   @Produces(MediaType.TEXT_HTML) 
   public String getBooksHTML(){ 
      String res = "<HTML><HEAD><TITLE>Books</TITLE></HEAD><BODY><TABLE>";
      for (Book b : bookDao.getAllBooks()){
          res += "<TR><TD>"+b.getId()+"</TD><TD>"+b.getAuthor()+"</TD><TD>"+b.getTitle()+"</TD></TR>";
      }
      res += "</TABLE></HTML>";
      return res;
   } 
   
   
   @GET 
   @Path("/book/{id}") 
   @Produces(MediaType.APPLICATION_XML) 
   public Book getBookById(@PathParam("id") int id){ 
       Book res = new Book();
       for (Book b : bookDao.getAllBooks()){
           if (b.getId() == id){
               res = b;
           }
       }
      return res;
   } 
   
   @GET 
   @Path("/bookJSON/{id}") 
   @Produces(MediaType.APPLICATION_JSON) 
   public Book getBookByIdJson(@PathParam("id") int id){ 
       Book res = new Book();
       for (Book b : bookDao.getAllBooks()){
           if (b.getId() == id){
               res = b;
           }
       }
      return res;
   } 
   
   @GET 
   @Path("/book/{id}/delete") 
   @Produces(MediaType.APPLICATION_XML) 
   public Response deleteBookById(@PathParam("id") int id){ 
      Response res = new Response("Book deleted", bookDao.deleteBook(id));
      return res;
   } 
   
   @POST
   @Path("/book/add") 
   public Response addBook(Book b){ 
       Response res = new Response("Book added", bookDao.addBook(b));
       return res;
   } 
   
   @POST
   @Path("/book/update") 
   public Response upsertBook(Book b){ 
       Response res = new Response("Book updated", bookDao.updateBook(b));
       return res;
   } 

}