package string.class_problems;

import java.util.Scanner;

class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public double calculateFinalAmount() {
        return amount;
    }
}

class CardPayment extends Payment {

    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {

    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {

    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }
}

public class PaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Payment payment;

            switch (type) {
                case "CARD":
                    payment = new CardPayment(amount);
                    break;

                case "WALLET":
                    payment = new WalletPayment(amount);
                    break;

                case "BANKTRANSFER":
                    payment = new BankTransferPayment(amount);
                    break;

                default:
                    System.out.println("Invalid payment type");
                    continue;
            }

            double finalAmount = payment.calculateFinalAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);

            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}