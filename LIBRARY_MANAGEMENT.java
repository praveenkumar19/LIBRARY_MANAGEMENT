import java.util.*;

class Book {
    int bookId;
    String bookName;
    boolean isIssued;

    Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isIssued = false;
    }

    void displayBook() {
        if (isIssued)
            System.out.println(bookId + "  " + bookName + "  " + "Issued");
        else
            System.out.println(bookId + "  " + bookName + "  " + "Available");
    }
}

class Library {
    Book[] books;
    int count;

    Library(int size) {
        books = new Book[size];
        count = 0;
    }

    void addBook(Book b) {
        books[count++] = b;
    }

    void showBooks() {
        System.out.println("\nID  Name  Status");
        for (int i = 0; i < count; i++) {
            books[i].displayBook();
        }
    }

    void issueBook(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].bookId == id && !books[i].isIssued) {
                books[i].isIssued = true;
                System.out.println("Book Issued Successfully");
                return;
            }
        }
        System.out.println("Book not available");
    }

    void returnBook(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].bookId == id && books[i].isIssued) {
                books[i].isIssued = false;
                System.out.println("Book Returned Successfully");
                return;
            }
        }
        System.out.println("Invalid return");
    }
}

public class libraryManagement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Library lib = new Library(5);
        lib.addBook(new Book(101, "Java"));
        lib.addBook(new Book(102, "Python"));
        lib.addBook(new Book(103, "C++"));
        lib.addBook(new Book(104, "Html"));
        lib.addBook(new Book(105, "C"));

        int choice = 1;
        while (choice != 4) {
            System.out.println("\n1.Show Books\n2.Issue Book\n3.Return Book\n4.Exit");
            choice = s.nextInt();

            if (choice == 1) {
                lib.showBooks();
            }

            if (choice == 2) {
                System.out.println("Enter Book ID to Issue: ");
                int id = s.nextInt();
                lib.issueBook(id);
            }

            if (choice == 3) {
                System.out.println("Enter Book ID to Return: ");
                int id = s.nextInt();
                lib.returnBook(id);
            }

            if (choice == 4) {
                System.out.println("Exit...........");
            }
        }
    }
}
