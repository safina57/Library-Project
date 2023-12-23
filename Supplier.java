import java.util.HashMap;
import java.util.Map;

public class Supplier {
    private Map<String,Book> books;
    public Supplier(){
        books=new HashMap<>();
    }
    public void add(Book book){
        books.put(book.getTitle(),book);
    }
    public boolean buyFromSupplier(Library library, String bookTitle) {
        if (books.containsKey(bookTitle)) {
            Book boughtBook = books.get(bookTitle);
            library.addBook(boughtBook);
            books.remove(bookTitle);
            System.out.println("Book '" + bookTitle + "' bought successfully!");
            return true;
        } else {
            System.out.println("Book '" + bookTitle + "' not available from the supplier.");
            return false;
        }
    }
}
