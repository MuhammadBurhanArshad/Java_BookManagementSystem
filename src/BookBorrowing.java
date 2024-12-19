import java.text.*;
import java.util.*;

public class BookBorrowing {
    private Date borrowDate;
    private Date returnDate;
    private int bookId;
    private int userId;
    
    public BookBorrowing(int bookId, int userId, Date borrowDate) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
    }
    
    // Getter and Setter methods
    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "Book ID: " + bookId + ", User ID: " + userId + ", Borrowed on: " + sdf.format(borrowDate) + 
               (returnDate != null ? ", Returned on: " + sdf.format(returnDate) : "");
    }
}
