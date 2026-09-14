package string.class_problems;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minimumPrice) {
                minimumPrice = prices[i];
            }

            int currentProfit = prices[i] - minimumPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int numberOfDays = scanner.nextInt();

        int[] prices = new int[numberOfDays];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < numberOfDays; i++) {
            prices[i] = scanner.nextInt();
        }

        System.out.println("Maximum Profit: " + maxProfit(prices));

        scanner.close();
    }
}