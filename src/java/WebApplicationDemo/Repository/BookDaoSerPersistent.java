package WebApplicationDemo.Repository;

import WebApplicationDemo.Util.SerializationManager;
import WebApplicationDemo.Models.Book;
import java.util.ArrayList;
import java.util.List;


public class BookDaoSerPersistent implements IBookDao {
    
    SerializationManager sm = new SerializationManager();
    List<Book> bookList = new ArrayList<>(); 
    //  Problem med relativa pathar, oklart varför, kanske nåt med GlassFish:s maskinanvändares permissions
      // eller att de deployade filerna är anorlunda organiserade än när man bygger "vanligt", utan webbserver
    String bookListPath = "C:/Users/s_ola/OneDrive/Dokument/NetBeansProjects/WebApplicationDemo/src/java/WebApplicationDemo/allaBocker.ser";
    
    public List<Book> getAllBooks(){ 
        return  (List<Book>)sm.deSerializeList(bookListPath);
    } 
    
    public void persistBooks(List<Book> bookList){
        sm.serializeList(bookList, bookListPath);
    }
    
}
