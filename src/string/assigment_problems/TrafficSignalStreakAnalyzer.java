package string.assigment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {

        char longestColor = signalLog.charAt(0);
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == currentColor) {
                currentStreak++;
            } else {
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {
                longestStreak = currentStreak;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: " + longestColor + " (" + longestStreak + ")");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter signal log (R/Y/G): ");
        String signalLog = scanner.nextLine().toUpperCase();

        if (signalLog.isEmpty()) {
            System.out.println("Error: Signal log cannot be empty.");
        } else {
            findLongestStreak(signalLog);
        }

        scanner.close();
    }
}