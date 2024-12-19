import java.util.ArrayList;
import java.util.List;

public class FeeManager {
    private List<FeeRecord> feeRecords;

    public FeeManager() {
        this.feeRecords = new ArrayList<>();
    }

    // Method to record a fee payment for a user
    public void recordPayment(int userId, double paymentAmount) {
        FeeRecord feeRecord = getFeeRecordByUserId(userId);
        if (feeRecord == null) {
            System.out.println("Fee record not found for user ID: " + userId);
            return;
        }

        double currentAmountDue = feeRecord.getAmountDue();
        if (paymentAmount <= 0) {
            System.out.println("Invalid payment amount.");
            return;
        }

        // Process payment and update the fee record
        if (paymentAmount >= currentAmountDue) {
            feeRecord.setAmountPaid(feeRecord.getAmountDue());
            feeRecord.setAmountDue(0);
            System.out.println("Full payment recorded.");
        } else {
            feeRecord.setAmountPaid(feeRecord.getAmountPaid() + paymentAmount);
            feeRecord.setAmountDue(currentAmountDue - paymentAmount);
            System.out.println("Partial payment recorded.");
        }
    }

    // Method to search for a user's fee record
    public FeeRecord searchFee(int userId) {
        FeeRecord feeRecord = getFeeRecordByUserId(userId);
        if (feeRecord != null) {
            System.out.println(feeRecord);
        } else {
            System.out.println("No fee record found for user ID: " + userId);
        }
        return feeRecord;
    }

    // Method to generate a fee report showing overdue fees
    public void generateFeeReport() {
        if (feeRecords.isEmpty()) {
            System.out.println("No fee records available.");
            return;
        }

        System.out.println("\nFee Report: ");
        for (FeeRecord feeRecord : feeRecords) {
            if (feeRecord.getAmountDue() > 0) {
                System.out.println(feeRecord);
            }
        }
    }

    // Helper method to find a fee record by user ID
    private FeeRecord getFeeRecordByUserId(int userId) {
        for (FeeRecord feeRecord : feeRecords) {
            if (feeRecord.getUserId() == userId) {
                return feeRecord;
            }
        }
        return null;
    }

    // Method to add fee record (can be used when a new user borrows a book)
    public void addFeeRecord(FeeRecord feeRecord) {
        feeRecords.add(feeRecord);
    }
}
