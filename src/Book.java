public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int availableCopies;

    public Book(int id, String title, String author, String genre, int availableCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableCopies = availableCopies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public String toFileString() {
        return this.id + "|" + this.title + "|" + this.author + "|" + this.genre + "|" + this.availableCopies;
    }

    public static Book fromFileString(String fileString) {
        String[] data = fileString.split("\\|");
        return new Book(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]));
    }
}
