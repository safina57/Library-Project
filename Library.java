import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
    private Map<Integer, User> users;
    private Admin admin;
    private Map<Integer, Book> availableBooks;
    private Map<Integer, Booking> bookedBooks;
    private ArrayList<String> wishedBooks;

    public Library() {
        admin = new Admin();
        users = new HashMap<>();
        availableBooks = new HashMap<>();
        bookedBooks = new HashMap<>();
        wishedBooks = new ArrayList<>();
    }
    public boolean logInAdmin() {
        Scanner scanner = new Scanner(System.in);

        if (admin != null) {
            System.out.print("Enter your ID: ");
            int ID = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter your Password: ");
            String password = scanner.nextLine();

            if (admin.logIn(ID, password)) {
                return true;
            } else {
                System.out.println("Invalid Admin credentials.");
            }
        } else {
            System.out.println("No Admin exists. Please sign in first.");
        }
        return false;
    }

    public void buyBooksFromSupplier(Supplier supplier) {
        if (wishedBooks.isEmpty()) {
            System.out.println("Wishlist is empty. Add books to the wishlist first.");
            return;
        }

        ArrayList<String> successfullyBoughtBooks = new ArrayList<>();

        for (String bookTitle : wishedBooks) {
            boolean bookBought = supplier.buyFromSupplier(this, bookTitle);
            if (bookBought) {
                successfullyBoughtBooks.add(bookTitle);
            }
        }

        wishedBooks.removeAll(successfullyBoughtBooks);
    }

    public void availableBooksInformation() {
        if (availableBooks.isEmpty()) {
            System.out.println("available books stock is empty");
        } else {
            System.out.println("Available Books list:");
            for (int i : availableBooks.keySet()) {
                System.out.println(availableBooks.get(i).toString());
                System.out.println("------");
            }
        }
    }

    public void BookedBooksInformation() {
        if (bookedBooks.isEmpty()) {
            System.out.println("there are no booked books");
        } else {
            System.out.println("Booked Books list:");
            for (int i : bookedBooks.keySet()) {
                System.out.println(bookedBooks.get(i).toString());
                System.out.println("------");
            }
        }
    }


    public void addBook(Book book) {
        availableBooks.put(book.getReference(), book);
    }

    public Map<Integer, Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void userSignIn(int userType) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();
        if(!users.containsKey(userID)) {
            User newUser;
            if (userType == 1) {
                newUser = new FreeUser();
            } else {
                newUser = new PremiumUser();
            }
            newUser.setID(userID);
            newUser.setPassword(password);
            users.put(userID, newUser);
            System.out.println("User signed in successfully!");
        }
        else{
            System.out.println("User already exits");
        }
    }
    public User userLogIn() {
        System.out.println("Logging in...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(userID)) {
            User user = users.get(userID);
            if (user.getPassword().equals(password)) {
                System.out.println("User logged in successfully!");
                return user;
            } else {
                System.out.println("Invalid password.");
            }
        } else {
            System.out.println("User not found.");
        }
        return null;
    }
    public void userBookBook(User user) {
        if(!availableBooks.isEmpty()) {
            this.availableBooksInformation();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the Reference of the Book to Book: ");
            int bookReference = scanner.nextInt();

            if (availableBooks.containsKey(bookReference)) {
                Book bookToBook = availableBooks.get(bookReference);
                user.addBook(bookToBook, this);

                System.out.println("Book booked successfully!");
            } else {
                System.out.println("Book not available or does not exist.");
            }
        }
        else{
            System.out.println("Stock is empty");
        }
    }

    public Map<Integer, Booking> getBookedBooks() {
        return bookedBooks;
    }
    public void userReturnBook(User user) {
        Scanner scanner = new Scanner(System.in);
        user.booksInformation();
        System.out.print("Enter the Reference of the Book to Return: ");
        int bookReference = scanner.nextInt();
        user.returnBook(bookReference,this);
    }
    public void userPayFine(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to pay: ");
        float amountToPay = scanner.nextFloat();
        user.payFine(amountToPay);
        System.out.println("Fine paid successfully!");
    }
    public void premiumUserWishForBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the title of the book to wish for: ");
        String bookTitle = scanner.nextLine();
        wishedBooks.add(bookTitle);
        System.out.println("Book wished successfully!");
    }
}