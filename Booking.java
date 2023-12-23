import java.time.LocalDate;

public class Booking {
    private Book book;
    private LocalDate returnDate;
    private int userID;
    Booking(){}

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        return book.toString()+"\nReturn date:"+returnDate+" Booked by the user with ID: "+userID;
    }
}
