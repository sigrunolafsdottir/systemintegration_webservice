package WebApplicationDemo.Repository;

import WebApplicationDemo.Models.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDaoDB implements IBookDao {
    
    public BookDaoDB ()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    
    public List<Book> getAllBooks(){
        List<Book> allBooks = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books",
                "sigrun","secretpassword");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from book")){
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                allBooks.add(new Book(id, title, author));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allBooks;
    }
    

    
    public void persistBooks(List <Book> bookList){
        //Nothing happens in this call as this class doesn't do persisting
        //just complying to interface
    }
    
       
}
