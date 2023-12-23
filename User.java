import java.util.HashMap;
import java.util.Map;

public  abstract class User {
    protected int ID;
    protected String password;
    protected Map<Integer,Booking> books;
    protected float fine;
    public User(){
        books=new HashMap<>();
        fine=0;
    }
    public void booksInformation() {
        if (books.isEmpty()) {
            System.out.println("You have no books yet.");
        } else {
            System.out.println("Your booked items:");
            for (int reference : books.keySet()) {
                System.out.println(books.get(reference).toString());
                System.out.println("------");
            }
        }
    }
    public abstract void addBook(Book book,Library library);
    public abstract void returnBook(int reference,Library library);
    public abstract void payFine(float v);
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public float getFine() {
        return fine;
    }

    public Map<Integer, Booking> getBooks() {
        return books;
    }

    public int getID() {
        return ID;
    }
    public String getPassword() {
        return password;
    }


}
