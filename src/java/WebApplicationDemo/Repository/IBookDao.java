package WebApplicationDemo.Repository;

import WebApplicationDemo.Models.Book;
import java.util.List;


public interface IBookDao {

    public List<Book> getAllBooks();
    
    //coming this afternoon
    public void persistBooks(List<Book> bookList);
}
