package string.class_problems;

public class PiggyBank {

    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > savings) {
            System.out.println("Insufficient savings.");
        } else {
            savings -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }
}