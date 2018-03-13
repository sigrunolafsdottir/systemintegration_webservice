package WebApplicationDemo;

import java.util.List;


public interface IBookDao {

    public List<Book> getAllBooks();
    public void persistBooks(List<Book> bookList);
}
