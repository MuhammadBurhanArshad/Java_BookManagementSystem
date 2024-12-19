public class Book {
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private int availableCopies;

    // Constructor
    public Book(int bookId, String title, String author, String genre, int availableCopies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableCopies = availableCopies;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    // toString method to display book details
    @Override
    public String toString() {
        return bookId + "," + title + "," + author + "," + genre + "," + availableCopies;
    }

    // Static method to parse a book from a CSV line
    public static Book fromString(String line) {
        String[] parts = line.split(",");
        int bookId = Integer.parseInt(parts[0]);
        String title = parts[1];
        String author = parts[2];
        String genre = parts[3];
        int availableCopies = Integer.parseInt(parts[4]);
        return new Book(bookId, title, author, genre, availableCopies);
    }
}
