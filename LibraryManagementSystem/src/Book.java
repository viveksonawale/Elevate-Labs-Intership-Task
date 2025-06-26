public abstract class Book {
    protected int id;
    protected String title;
    protected String author;
    protected boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public int getId() {
        return id;
    }

    public abstract void displayDetails();
}
