package WebApplicationDemo.Util;

import WebApplicationDemo.Models.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class SerializationManager {
    
    public void serializeList(List<Book> list, String filePath ){
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);) {
            
            objectOut.writeObject(list);
            System.out.printf("Böckerna sparade i %s\n", filePath);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public List<Book> deSerializeList(String filePath){
        
        List<Book> list = new ArrayList<Book>();
        try (FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream in = new ObjectInputStream(fileIn);) {
            
            list = (List<Book>) in.readObject();
            System.out.println("deserialize" + list.size()+ " books");
            return list;
        }
        catch(IOException e) {
            e.printStackTrace();
            System.out.println("Något gick fel");
        }
        catch(ClassNotFoundException e) {
            System.out.println("Book okänd klass");
        }
        return list;
    }
}
