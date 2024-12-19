import java.io.*;
import java.util.*;

public class UserManager {
    private List<User> users;
    private static final String FILE_NAME = "users.txt";

    public UserManager() {
        this.users = new ArrayList<>();
        loadUsersFromFile();
    }

    // Load users from file
    private void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int userId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String contact = parts[2].trim();
                    users.add(new User(userId, name, contact));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file: " + e.getMessage());
        }
    }

    // Save users to file
    private void saveUsersToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(user.getUserId() + "," + user.getName() + "," + user.getContactInformation());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users to file: " + e.getMessage());
        }
    }

    // Add User
    public void addUser(User user) {
        users.add(user);
        saveUsersToFile(); // Save after adding a user
    }

    // Delete User
    public void deleteUser(int userId) {
        users.removeIf(user -> user.getUserId() == userId);
        saveUsersToFile(); // Save after deleting a user
    }

    // Search User by Name or ID
    public List<User> searchUsers(String keyword) {
        List<User> searchResults = new ArrayList<>();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(keyword.toLowerCase()) || 
                String.valueOf(user.getUserId()).contains(keyword)) {
                searchResults.add(user);
            }
        }
        return searchResults;
    }

    // Display All Users
    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            users.forEach(System.out::println);
        }
    }
}
