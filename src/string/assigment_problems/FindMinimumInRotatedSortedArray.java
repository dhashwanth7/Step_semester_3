package string.assigment_problems;

import java.util.Scanner;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = left + (right - left) / 2;

            if (nums[middle] > nums[right]) {
                // Minimum is in the right half
                left = middle + 1;
            } else {
                // Minimum is in the left half, including middle
                right = middle;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println(
                    "Error: Array must contain at least one element."
            );
        } else {

            int[] nums = new int[n];

            System.out.println("Enter array elements:");

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.println("Minimum Element: " + findMin(nums));
        }

        scanner.close();
    }
}