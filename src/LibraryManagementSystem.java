public class LibraryManagementSystem {
    public static void main(String[] args) {
        CustomFileManager fileManager = new CustomFileManager();

        CustomArrayList books = new CustomArrayList();
        books.add(new Book(1, "Java Programming", "Author A", "Programming", 5));
        books.add(new Book(2, "Data Structures", "Author B", "Programming", 3));
        books.add(new Book(3, "Database Management", "Author C", "Technology", 7));

        fileManager.customWriteToFile("books.txt", books);

        CustomArrayList loadedBooks = fileManager.customReadFromFile("books.txt");

        for (int i = 0; i < loadedBooks.size(); i++) {
            Book book = (Book) loadedBooks.get(i);
            System.out.println(book.getId() + " - " + book.getTitle());
        }
    }
}
