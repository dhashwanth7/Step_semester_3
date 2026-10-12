package string.class_problems;

import java.util.Scanner;

public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println(reversed);

        if (word.equals(reversed)) {
            System.out.println(word + " - palindrome");
        } else {
            System.out.println(word + " - not a palindrome");
        }

        sc.close();
    }
}