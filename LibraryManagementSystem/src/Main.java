import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Add sample data
        library.addBook(new PrintBook(1, "Java Basics", "John Doe"));
        library.addBook(new PrintBook(2, "DSA with Java", "Jane Smith"));
        library.addUser(new StudentUser(101, "Alice"));
        library.addUser(new StudentUser(102, "Bob"));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display all books");
            System.out.println("2. Display all users");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    library.displayAllBooks();
                    break;
                case 2:
                    library.displayAllUsers();
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(bookId, userId);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();
                    library.returnBook(returnBookId);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
