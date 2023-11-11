package Exercise2;

public class Book {
    private int code;
    private String title;
    private String author;
    private boolean available;

    public Book(int code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}