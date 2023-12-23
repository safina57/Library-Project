import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PremiumUser extends User{
    @Override
    public void addBook(Book book,Library library) {
        if(fine<=5) {
            LocalDate returnDate=LocalDate.now().plusDays(7);
            Booking booking=new Booking();
            booking.setBook(book);
            booking.setReturnDate(returnDate);
            booking.setUserID(ID);
            books.put(book.getReference(), booking);
            library.getAvailableBooks().remove(book.getReference());
            library.getBookedBooks().put(book.getReference(),booking);
            System.out.println("Book added successfully !");
        }
        else {
            System.out.println("You need to pay your fine first");
        }
    }
    @Override
    public void returnBook(int reference,Library library){
        if (books.containsKey(reference)) {
            Booking bookingToReturn = books.get(reference);
            if (bookingToReturn.getReturnDate().isAfter(LocalDate.now())) {


                System.out.println("Book returned successfully!");
            } else {
                fine+=1;
                System.out.println("Book returned late. Fine may be applicable.");
            }
            library.getAvailableBooks().put(reference, bookingToReturn.getBook());
            library.getBookedBooks().remove(reference);
            books.remove(reference);
        } else {
            System.out.println("Book not found in the user's list.");
        }
    }
    @Override
    public void payFine(float v){
        if(v>fine){
            fine=0;
        }
        else {
            fine -= v;
        }
    }
}
