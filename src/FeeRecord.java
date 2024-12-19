public class FeeRecord {
    private int userId;
    private double amountDue;
    private double amountPaid;

    public FeeRecord(int userId, double amountDue) {
        this.userId = userId;
        this.amountDue = amountDue;
        this.amountPaid = 0; // Initialize with no payment made yet
    }

    public int getUserId() {
        return userId;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Amount Due: " + amountDue + ", Amount Paid: " + amountPaid;
    }
}
