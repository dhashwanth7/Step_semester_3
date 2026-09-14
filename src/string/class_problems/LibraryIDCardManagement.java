package string.class_problems;

import java.util.Scanner;

public class LibraryIDCardManagement {

    static class IdCard {

        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int booksIssued = sc.nextInt();

        IdCard ravi = new IdCard(name, booksIssued);

        IdCard duplicate = ravi;

        int updatedBooks = sc.nextInt();
        duplicate.booksIssued = updatedBooks;

        IdCard separate = new IdCard(name, updatedBooks);

        System.out.println(
                "Ravi's booksIssued (via first variable): "
                        + ravi.booksIssued
        );

        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        System.out.println("separate == ravi: " + (separate == ravi));

        sc.close();
    }
}