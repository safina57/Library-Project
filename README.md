# Library System Documentation

## Classes

### 1. Book Class 

- Manages information about a book.
- **Attributes:**
  - `reference`: unique identifier for the book.
  - `title`: title of the book.
  - `author`: author(s) of the book.
- **Methods:**
  - `setBook()`: accepts user input to set book information.
  - `toString()`: provides a string representation of the book.

### 2. Booking Class 

- Represents a booked instance of a book.
- **Attributes:**
  - `book`: the booked book.
  - `returnDate`: the expected return date.
  - `userID`: ID of the user who booked the book.
- **Methods:**
  - `setBook(Book book)`: sets the booked book.
  - `setReturnDate(LocalDate returnDate)`: sets the expected return date.
  - `setUserID(int userID)`: sets the user ID for the booking.
  - `toString()`: provides a string representation of the booking.

### 3. Admin Class 

- Manages admin-related functionalities.
- **Attributes:**
  - `exists`: static variable to check if an admin exists.
  - `ID`: admin ID.
  - `password`: admin password.
- **Methods:**
  - `signIn()`: allows the admin to sign in.
  - `logIn(int ID, String password)`: allows the admin to log in.

### 4. User Class 

- Abstract class representing a library user.
- **Attributes:**
  - `ID`: user ID.
  - `password`: user password.
  - `books`: a map of booked books by the user.
  - `fine`: fine amount for the user.
- **Methods:**
  - `booksInformation()`: displays information about the user's booked books.
  - `addBook(Book book, Library library)`: abstract method to add a book to the user's collection.
  - `returnBook(int reference, Library library)`: abstract method to return a booked book.
  - `payFine(float amount)`: abstract method to pay the user's fine.

### 5. FreeUser Class 

- Represents a free user in the library system.
- Inherits from `User`.
- Implements abstract methods to manage booking, returning, and paying fines.

### 6. PremiumUser Class 

- Represents a premium user in the library system.
- Inherits from `User`.
- Implements abstract methods to manage booking, returning, and paying fines.

### 7. Supplier Class 

- Represents a book supplier for the library.
- Manages a collection of books that can be purchased by the library.
- **Methods:**
  - `add(Book book)`: adds a book to the supplier's collection.
  - `buyFromSupplier(Library library, String bookTitle)`: allows the library to buy a book from the supplier.

### 8. Library Class 

- Represents the library system.
- Manages users, admin, available books, booked books, and wished books.
- **Methods:**
  - `signInAdmin()`: allows an admin to sign in.
  - `logInAdmin()`: allows an admin to log in.
  - `buyBooksFromSupplier(Supplier supplier)`: allows the library to buy books from the supplier.
  - `availableBooksInformation()`: displays information about available books.
  - `BookedBooksInformation()`: displays information about booked books.
  - `addBook(Book book)`: adds a book to the library's available books.
  - `userSignIn(int userType)`: allows a user to sign in.
  - `userLogIn()`: allows a user to log in.
  - `userBookBook(User user)`: allows a user to book a book.
  - `userReturnBook(User user)`: allows a user to return a booked book.
  - `userPayFine(User user)`: allows a user to pay fines.
  - `premiumUserWishForBook()`: allows a premium user to wish for a book.

### 9. Main Class 

- The main class to run the library system.
- Manages the main menu for signing in, logging in, and accessing admin or user functionalities.
- **Methods:**
  - `performAdminActions(Library library, Supplier supplier)`: allows the admin to perform various actions.
  - `performUserActions(Library library, User user)`: allows the user to perform various actions.
