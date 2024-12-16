import java.io.File;
import java.io.IOException;

public class CustomFileManager {

    public void customWriteToFile(String fileName, CustomArrayList books) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            String fileContent = books.toFileString();
            java.nio.file.Files.write(file.toPath(), fileContent.getBytes());
        } catch (IOException e) {
            System.err.println("Error saving books: " + e.getMessage());
        }
    }

    public CustomArrayList customReadFromFile(String fileName) {
        CustomArrayList books = new CustomArrayList();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return books;
            }

            String fileContent = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            books = CustomArrayList.fromFileString(fileContent);
        } catch (IOException e) {
            System.err.println("Error loading books: " + e.getMessage());
        }
        return books;
    }
}
