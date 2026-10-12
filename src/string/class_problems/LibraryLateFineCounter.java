package string.class_problems;

import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();

    public String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, daysLate);
                    break;

                case "DVD":
                    item = new DVD(title, daysLate);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title, daysLate);
                    break;

                default:
                    System.out.println("Invalid item type");
                    continue;
            }

            double fine = item.calculateFine();

            System.out.printf("%s: %.2f%n", item.getTitle(), fine);

            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);

        sc.close();
    }
}