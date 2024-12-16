# Library Management System (LMS)

## Overview
The Library Management System (LMS) is a custom Java application designed to automate and manage various library operations such as book registration, user management, borrowing, returns, fee tracking, and transaction history. The system is built using custom data structures and algorithms to improve efficiency, scalability, and performance.

### Key Features:
- **Book Management**: Add, delete, search, and sort books in the library.
- **User Management**: Add and delete users, and search users by ID or name.
- **Book Borrowing and Returning**: Borrow and return books while tracking overdue fees.
- **Fee Management**: Track and record overdue fees, generate fee reports.
- **Transaction History**: View and generate detailed reports of borrowing activities.
- **Custom Data Structures**: Linked lists, queues, stacks, and heaps to manage data efficiently.
- **File Management**: Save, load, and export data to ensure data persistence.

---

## Project Structure

```
LibraryManagementSystem/
├── src/
│   ├── BookManagement.java
│   ├── UserManagement.java
│   ├── BorrowReturn.java
│   ├── FeeManagement.java
│   ├── TransactionHistory.java
│   ├── CustomArrayList.java
│   └── Main.java
├── .gitignore
└── README.md
```

---

## Setup Instructions

### Prerequisites:
- Java 8 or higher installed on your machine.
- Basic understanding of Java programming.

### Installation Steps:
1. **Clone the repository**:
    ```bash
    git clone <repository-url>
    ```

2. **Navigate to the `src` directory**:
    ```bash
    cd LibraryManagementSystem/src
    ```

3. **Compile the Java files**:
    ```bash
    javac *.java
    ```

4. **Run the program**:
    ```bash
    java Main
    ```

---

## Usage

### 1. **Adding a New Book**:
- The system allows you to add new books by entering the required details (Title, Author, Genre, and Availability).

### 2. **Borrowing a Book**:
- Users can borrow books by searching for them by title, author, or genre, and the system will track the borrow date.

### 3. **Returning a Book**:
- When returning a book, the system calculates overdue fees based on the return date.

### 4. **Managing Fees**:
- The system tracks overdue fees for each user and generates fee reports.

### 5. **Viewing Transaction History**:
- The system provides detailed transaction reports for books borrowed, returned, and associated fees.

---

## Custom Data Structures

- **Custom ArrayList**: A dynamic array-based implementation for storing lists of books and users.
- **Linked List**: Used for managing dynamic data, allowing efficient insertion and deletion.
- **Queue**: Used for managing borrowing requests and fee payment queues.
- **Stack**: Used for handling undo functionality for critical changes (e.g., accidental book deletion).
- **Heap**: Used to optimize searching and sorting, especially for prioritizing the most borrowed or overdue books.

---

## Git Ignore

This project includes a `.gitignore` to exclude unnecessary files like:
- Compiled `.class` files
- IDE-specific files (e.g., `.vscode`, `.idea`)
- Log files and package files (e.g., `.jar`, `.zip`)

---

## Conclusion

The Library Management System offers an efficient and scalable solution for managing library operations. It uses custom data structures and algorithms for optimized performance. The system is designed to handle an increasing volume of books and users, ensuring smooth operations even as the library grows.

---

## License

This project is open source and available under the MIT License.
