package string.class_problems;

import java.util.Scanner;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char character = Character.toLowerCase(text.charAt(i));

            if (character == 'a' || character == 'e' ||
                    character == 'i' || character == 'o' ||
                    character == 'u') {

                vowels++;

            } else if (character != ' ') {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels +
                " | Consonants: " + consonants);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String text = scanner.nextLine();

        if (text.trim().isEmpty()) {
            System.out.println("Error: Text cannot be empty.");
        } else {
            countVowelsAndConsonants(text);
        }

        scanner.close();
    }
}