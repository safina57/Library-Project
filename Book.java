import java.util.Scanner;

public class Book {
    private int reference;
    private String title;
    private String author;

    public Book() {}
    public void setBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Reference: ");
        this.reference = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: ");
        this.title = sc.nextLine();
        System.out.print("Authors: ");
        this.author = sc.nextLine();
    }
    public int getReference() {
        return reference;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return author;
    }
    @Override
    public String toString() {
        return "Book: reference=" + reference + ", title='" + title + "', authors='" + author + "'";
    }

}
