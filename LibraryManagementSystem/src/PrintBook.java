public class PrintBook extends Book {
    public PrintBook(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public void displayDetails() {
        System.out.println("PrintedBook [ID: " + id + ", Title: " + title + ", Author: " + author + ", Issued: " + isIssued + "]");
    }
}
