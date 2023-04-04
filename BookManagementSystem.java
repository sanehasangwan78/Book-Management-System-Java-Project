import java.util.ArrayList;
import java.util.Scanner;
 
class Book {
     String title;
     String author;
     int year;
     double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author; 
        this.year = year;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return title + " by " + author + " (" + year + ") $" + price;
    }
}

class BookStore {
    private ArrayList<Book> books;

     public BookStore() {
        books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
             if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
}

public class BookManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookStore bookStore = new BookStore();
        int choice = 0;
        do {
            System.out.println("1. Add a book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the book title: ");
                    String title = input.next();
                    System.out.print("Enter the book author: ");
                    String author = input.next();
                    System.out.print("Enter the book year: ");
                    int year = input.nextInt();
                     System.out.print("Enter the book price: ");
                    double price = input.nextDouble();
                    Book book = new Book(title, author, year, price);
                    bookStore.addBook(book);
                    break;
                case 2:
                    bookStore.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter the book title: ");
                    title = input.next();
                    bookStore.searchBookByTitle(title);
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }
}