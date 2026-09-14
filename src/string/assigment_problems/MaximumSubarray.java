package string.assigment_problems;

import java.util.Scanner;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maximumSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maximumSum = Math.max(maximumSum, currentSum);
        }

        return maximumSum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Error: Array must contain at least one element.");
        } else {

            int[] nums = new int[n];

            System.out.println("Enter array elements:");

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.println("Maximum Subarray Sum: "
                    + maxSubArray(nums));
        }

        scanner.close();
    }
}