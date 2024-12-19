import java.util.*;

public class BorrowingManager {
    private List<BookBorrowing> borrowings;
    private static final long MILLIS_IN_A_DAY = 24 * 60 * 60 * 1000;  // Milliseconds in a day

    public BorrowingManager() {
        this.borrowings = new ArrayList<>();
    }

    // Method to borrow a book
    public void borrowBook(int bookId, int userId) {
        Date borrowDate = new Date();  // Current date when the book is borrowed
        BookBorrowing borrowing = new BookBorrowing(bookId, userId, borrowDate);
        borrowings.add(borrowing);
        System.out.println("Book ID " + bookId + " borrowed by User ID " + userId + " on " + borrowDate);
    }

    // Method to return a book and calculate any overdue fees
    public void returnBook(int bookId, int userId) {
        BookBorrowing borrowing = findBorrowing(bookId, userId);
        if (borrowing != null) {
            Date returnDate = new Date();  // Current date when the book is returned
            borrowing.setReturnDate(returnDate);

            long overdueDays = calculateOverdueDays(borrowing);
            if (overdueDays > 0) {
                double fee = overdueDays * 1.0;  // Example: 1.0 fee per overdue day
                System.out.println("Book ID " + bookId + " returned by User ID " + userId + ". Overdue days: " + overdueDays + ". Fee: $" + fee);
            } else {
                System.out.println("Book ID " + bookId + " returned by User ID " + userId + " on time.");
            }
        } else {
            System.out.println("No borrowing record found for Book ID " + bookId + " and User ID " + userId);
        }
    }

    // Method to check availability of a book
    public boolean checkAvailability(int bookId) {
        for (BookBorrowing borrowing : borrowings) {
            if (borrowing.getBookId() == bookId && borrowing.getReturnDate() == null) {
                return false;  // Book is already borrowed and not returned yet
            }
        }
        return true;  // Book is available
    }

    // Method to search borrowing history of a user or book
    public List<BookBorrowing> searchBorrowingHistory(int id, boolean isUserSearch) {
        List<BookBorrowing> result = new ArrayList<>();
        for (BookBorrowing borrowing : borrowings) {
            if ((isUserSearch && borrowing.getUserId() == id) || 
                (!isUserSearch && borrowing.getBookId() == id)) {
                result.add(borrowing);
            }
        }
        return result;
    }

    // Helper method to find the borrowing record for a specific book and user
    private BookBorrowing findBorrowing(int bookId, int userId) {
        for (BookBorrowing borrowing : borrowings) {
            if (borrowing.getBookId() == bookId && borrowing.getUserId() == userId && borrowing.getReturnDate() == null) {
                return borrowing;
            }
        }
        return null;  // No matching borrowing record
    }

    // Helper method to calculate overdue days
    private long calculateOverdueDays(BookBorrowing borrowing) {
        if (borrowing.getReturnDate() == null) {
            return 0;
        }
        long diffInMillis = borrowing.getReturnDate().getTime() - borrowing.getBorrowDate().getTime();
        long diffInDays = diffInMillis / MILLIS_IN_A_DAY;
        return diffInDays > 14 ? diffInDays - 14 : 0;  // Assuming 14 days for normal borrowing period
    }

    // Method to display all borrowings
    public void displayAllBorrowings() {
        if (borrowings.isEmpty()) {
            System.out.println("No borrowings found.");
        } else {
            borrowings.forEach(System.out::println);
        }
    }
}
