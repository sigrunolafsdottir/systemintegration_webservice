package WebApplicationDemo.Util;

import WebApplicationDemo.Models.Book;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CreateJSONFile {

    Gson gson = new Gson();
    List<Book> bookList = new ArrayList<>(); 
    
    
    CreateJSONFile(){
        
      Book b1 = new Book(1,"Wuthering Heights", "Emily Bronte");
      Book b2 = new Book(2, "Jayne Eyre", "Charlotte Bronte");
      Book b3 = new Book(3, "Crime and Punishment", "Fjodor Dostovjevsky");
      Book b4 = new Book(4, "Madame Bovary", "Gustave Flaubert");
      Book b5 = new Book(5, "Catcher in the Rye", "J.D. Salinger");
      Book b6 = new Book(6, "Pale King", "David Foster Wallace");
      Book b7 = new Book(7, "Sandman, vol 1", "Neil Gaiman");
      
      bookList.add(b1);
      bookList.add(b2);
      bookList.add(b3);
      bookList.add(b4);
      bookList.add(b5);
      bookList.add(b6);
      bookList.add(b7);
      
      String json = gson.toJson(bookList);
      
      try (FileWriter writer = new FileWriter("src/java/WebApplicationDemo/allaBockerJSON.json");) {
        writer.write(json);
  
      } catch (IOException e) {
         e.printStackTrace();
      }
        
    }


    public static void main(String[] args) {
        CreateJSONFile cr = new CreateJSONFile();
    }
}
