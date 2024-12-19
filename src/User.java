public class User {
    private int userId;
    private String name;
    private String contactInformation;

    public User(int userId, String name, String contactInformation) {
        this.userId = userId;
        this.name = name;
        this.contactInformation = contactInformation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name + ", Contact: " + contactInformation;
    }
}
