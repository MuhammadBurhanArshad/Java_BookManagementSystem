import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager bookManager = new BookManager();
        UserManager userManager = new UserManager();
        BorrowingManager borrowingManager = new BorrowingManager();

        // Dummy Books
        bookManager.addBook(new Book(1, "Java Basics", "John Doe", "Programming", 5));
        bookManager.addBook(new Book(2, "Advanced Java", "Jane Doe", "Programming", 3));

        // Dummy Users
        userManager.addUser(new User(1, "Muhammad Burhan", "burhan@example.com"));
        userManager.addUser(new User(2, "Alice Smith", "alice@example.com"));

        while (true) {
            System.out.println("\nManagement System");
            System.out.println("1. Book Management");
            System.out.println("2. User Management");
            System.out.println("3. Borrow Management");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left by nextInt
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option.");
                scanner.nextLine(); // Consume invalid input
                continue; // Skip the rest of the loop and ask for input again
            }

            switch (choice) {
                case 1:
                    // Book Management Menu
                    handleBookManagement(scanner, bookManager);
                    break;

                case 2:
                    // User Management Menu
                    handleUserManagement(scanner, userManager);
                    break;

                case 3:
                    // Borrow Management Menu
                    handleBorrowManagement(scanner, borrowingManager, bookManager, userManager);
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Book Management Handling
    public static void handleBookManagement(Scanner scanner, BookManager bookManager) {
        while (true) {
            System.out.println("\nBook Management");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Search Book");
            System.out.println("4. Sort Books");
            System.out.println("5. Display All Books");
            System.out.println("6. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Available Copies: ");
                    int availableCopies = scanner.nextInt();
                    scanner.nextLine();
                    bookManager.addBook(new Book(bookId, title, author, genre, availableCopies));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();
                    bookManager.deleteBook(deleteId);
                    break;

                case 3:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    List<Book> searchResults = bookManager.searchBooks(keyword);
                    if (searchResults.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        searchResults.forEach(book -> System.out.println(book));
                    }
                    break;

                case 4:
                    System.out.print("Enter attribute to sort by (title/author/genre): ");
                    String attribute = scanner.nextLine();
                    bookManager.sortBooks(attribute);
                    break;

                case 5:
                    bookManager.displayAllBooks();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // User Management Handling
    public static void handleUserManagement(Scanner scanner, UserManager userManager) {
        while (true) {
            System.out.println("\nUser Management");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Search User");
            System.out.println("4. Display All Users");
            System.out.println("5. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact Information: ");
                    String contact = scanner.nextLine();
                    userManager.addUser(new User(userId, name, contact));
                    System.out.println("User added successfully.");
                    break;

                case 2:
                    System.out.print("Enter User ID to delete: ");
                    int deleteUserId = scanner.nextInt();
                    scanner.nextLine();
                    userManager.deleteUser(deleteUserId);
                    break;

                case 3:
                    System.out.print("Enter keyword to search: ");
                    String keyword = scanner.nextLine();
                    List<User> searchResults = userManager.searchUsers(keyword);
                    if (searchResults.isEmpty()) {
                        System.out.println("No users found.");
                    } else {
                        searchResults.forEach(user -> System.out.println(user));
                    }
                    break;

                case 4:
                    userManager.displayAllUsers();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Borrow Management Handling
    public static void handleBorrowManagement(Scanner scanner, BorrowingManager borrowingManager, BookManager bookManager, UserManager userManager) {
        while (true) {
            System.out.println("\nBorrow Management");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Display All Borrowings");
            System.out.println("4. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Borrow Book
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowBookId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int borrowUserId = scanner.nextInt();
                    scanner.nextLine();
                    borrowingManager.borrowBook(borrowBookId, borrowUserId);
                    break;

                case 2:
                    // Return Book
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int returnUserId = scanner.nextInt();
                    scanner.nextLine();
                    borrowingManager.returnBook(returnBookId, returnUserId);
                    break;

                case 3:
                    // Display All Borrowings
                    borrowingManager.displayAllBorrowings();
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
