import java.io.*;
import java.util.*;

public class BookManager {
    private static final String FILE_NAME = "books.txt";
    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
        loadBooksFromFile();
    }

    // Add a book to the list
    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    // Remove a book by book ID
    public void deleteBook(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == bookId) {
                books.remove(i);
                saveBooksToFile();
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Search for books by title, author, or genre
    public List<Book> searchBooks(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // Sort books by title, author, or genre using MergeSort
    public void sortBooks(String attribute) {
        switch (attribute.toLowerCase()) {
            case "title":
                mergeSort(books, 0, books.size() - 1, "title");
                break;
            case "author":
                mergeSort(books, 0, books.size() - 1, "author");
                break;
            case "genre":
                mergeSort(books, 0, books.size() - 1, "genre");
                break;
            default:
                System.out.println("Invalid attribute for sorting.");
                return;
        }
        System.out.println("Books sorted by " + attribute + " successfully.");
    }

    // Display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // MergeSort algorithm to sort books based on the chosen attribute
    private void mergeSort(List<Book> books, int left, int right, String attribute) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(books, left, middle, attribute);
            mergeSort(books, middle + 1, right, attribute);
            merge(books, left, middle, right, attribute);
        }
    }

    // Merging two subarrays for MergeSort
    private void merge(List<Book> books, int left, int middle, int right, String attribute) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        List<Book> leftList = new ArrayList<>();
        List<Book> rightList = new ArrayList<>();

        // Copy data to temp lists
        for (int i = 0; i < n1; i++) {
            leftList.add(books.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightList.add(books.get(middle + 1 + j));
        }

        // Merge the temp lists back into the original list
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            int comparisonResult = 0;
            switch (attribute.toLowerCase()) {
                case "title":
                    comparisonResult = leftList.get(i).getTitle().compareTo(rightList.get(j).getTitle());
                    break;
                case "author":
                    comparisonResult = leftList.get(i).getAuthor().compareTo(rightList.get(j).getAuthor());
                    break;
                case "genre":
                    comparisonResult = leftList.get(i).getGenre().compareTo(rightList.get(j).getGenre());
                    break;
            }

            if (comparisonResult <= 0) {
                books.set(k, leftList.get(i));
                i++;
            } else {
                books.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftList, if any
        while (i < n1) {
            books.set(k, leftList.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of rightList, if any
        while (j < n2) {
            books.set(k, rightList.get(j));
            j++;
            k++;
        }
    }

    // Load books from file (reading from text file)
    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                books.add(Book.fromString(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous book data found. Starting with an empty list.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save books to file (writing to text file)
    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
