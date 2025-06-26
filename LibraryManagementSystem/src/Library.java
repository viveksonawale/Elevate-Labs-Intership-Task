import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayDetails();
        }
    }

    public void displayAllUsers() {
        for (User user : users) {
            user.displayUser();
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        book.setIssued(true);
        System.out.println("Book issued to user: " + user.name);
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book was not issued.");
            return;
        }

        book.setIssued(false);
        System.out.println("Book returned successfully.");
    }

    private Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    private User findUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}
