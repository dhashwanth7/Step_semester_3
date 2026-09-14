package string.assigment_problems;

import java.util.Scanner;

public class ATMPinLengthValidator {

    public static void checkPinLength(String pin) {

        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (pin.isEmpty()) {
            System.out.println("Error: PIN cannot be empty.");
        } else {
            checkPinLength(pin);
        }

        scanner.close();
    }
}