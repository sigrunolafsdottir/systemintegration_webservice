package WebApplicationDemo.Repository;

import WebApplicationDemo.Models.Book;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;


public class BookDaoJSONPersistent implements IBookDao {
    
    Gson gson = new Gson();
    String bookListPath = "C:/Users/s_ola/OneDrive/Dokument/NetBeansProjects/WebApplicationDemo/src/java/WebApplicationDemo/Repository/allaBockerJSON.json";
    
    
    public List<Book> getAllBooks(){ 
      String json = new String();
      List<Book> bookList = new ArrayList<Book>();
      
      try (BufferedReader br = new BufferedReader(
            new FileReader(bookListPath));) {

          //FÖr att kunna uttrycka att det vi ska läsa är en List<Book>
        Type listType = new TypeToken<ArrayList<Book>>(){}.getType();
        bookList = new Gson().fromJson(br, listType);
  
      } catch (IOException e) {
         e.printStackTrace();
      }
      
      return bookList;
      
   } 
    
    public void persistBooks(List <Book> bookList){
      String json = gson.toJson(bookList);
      
      try (FileWriter writer = new FileWriter(bookListPath);) {
        writer.write(json);
  
      } catch (IOException e) {
         e.printStackTrace();
      }
    }
        
}
