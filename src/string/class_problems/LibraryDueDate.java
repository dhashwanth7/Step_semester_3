package string.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26);
    }
}

class Book extends LibraryItem {

    public Book(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD extends LibraryItem {

    public DVD(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine extends LibraryItem {

    public Magazine(String title) {
        super(title);
    }

    @Override
    public LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

public class LibraryDueDate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');

            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type.toUpperCase()) {
                case "BOOK":
                    item = new Book(title);
                    break;

                case "DVD":
                    item = new DVD(title);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title);
                    break;

                default:
                    System.out.println("Invalid item type");
                    continue;
            }

            System.out.println(
                title + ": " + item.calculateDueDate()
            );
        }

        sc.close();
    }
}