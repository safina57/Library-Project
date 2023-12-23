import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Admin admin = null;
        User currentUser = null;
        Supplier supplier = new Supplier();
        System.out.println("---------Welcome to the library system---------");
        Scanner scanner = new Scanner(System.in);

        int userType;
        int choice;
        do {
            System.out.println("1. Sign in as Admin");
            System.out.println("2. Sign in as User");
            System.out.println("3. Log in as User");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    if (admin == null) {
                        admin = new Admin();
                        admin.signIn();
                        library.setAdmin(admin);
                        System.out.println("Admin signed in successfully!");
                    } else {
                        System.out.println("Admin already exists. You can log in.");
                        boolean adminLoggedIn = library.logInAdmin();
                        if (adminLoggedIn) {
                            performAdminActions(library, supplier);
                        }
                    }
                    break;
                case 2:
                    System.out.println("1. Free User");
                    System.out.println("2. Premium User");
                    System.out.print("Choose a user type: ");
                    userType = scanner.nextInt();
                    scanner.nextLine();

                    library.userSignIn(userType);
                    break;
                case 3:
                    currentUser=library.userLogIn();
                    if (currentUser != null) {
                        performUserActions(library, currentUser);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void performAdminActions(Library library, Supplier supplier) {
        Scanner scanner = new Scanner(System.in);

        int adminChoice;
        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Buy Books from Supplier");
            System.out.println("2. View Available Books");
            System.out.println("3. View Booked Books");
            System.out.println("4. Add Book to Library");
            System.out.println("5. Add Book to Supplier");
            System.out.println("6. Log Out");

            System.out.print("Choose an option: ");
            adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1:
                    library.buyBooksFromSupplier(supplier);
                    break;
                case 2:
                    library.availableBooksInformation();
                    break;
                case 3:
                    library.BookedBooksInformation();
                    break;
                case 4:
                    Book book=new Book();
                    book.setBook();
                    library.addBook(book);
                    break;
                case 5:
                    Book book1=new Book();
                    book1.setBook();
                    supplier.add(book1);
                    break;
                case 6:
                    System.out.println("Logging out...");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (adminChoice != 6);
    }
    private static void performUserActions(Library library, User user) {
        Scanner scanner = new Scanner(System.in);

        int userChoice;
        do {
            System.out.println("\nUser Menu:");
            System.out.println("1. Book a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Show me my Books");
            System.out.println("4. Get Fine");
            System.out.println("5. Pay Fine");
            System.out.println("6. Wish for a Book (Premium User Only)");
            System.out.println("7. Log Out");

            System.out.print("Choose an option: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    library.userBookBook(user);
                    break;
                case 2:
                    library.userReturnBook(user);
                    break;
                case 3:
                    user.booksInformation();
                    break;
                case 4:
                    System.out.println("Fine= "+user.getFine()+" DT");
                    break;
                case 5:
                    library.userPayFine(user);
                    break;
                case 6:
                    if (user instanceof PremiumUser) {
                        library.premiumUserWishForBook();
                    } else {
                        System.out.println("Invalid option for Free User.");
                    }
                    break;
                case 7:
                    System.out.println("Logging out...");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (userChoice != 7);
    }
}
