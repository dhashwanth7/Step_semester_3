package string.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();

        // Empty prefix
        prefixSumFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum += num;

            int requiredSum = currentSum - k;

            if (prefixSumFrequency.containsKey(requiredSum)) {
                count += prefixSumFrequency.get(requiredSum);
            }

            prefixSumFrequency.put(
                    currentSum,
                    prefixSumFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
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

            System.out.print("Enter k: ");
            int k = scanner.nextInt();

            int result = subarraySum(nums, k);

            System.out.println("Number of Subarrays: " + result);
        }

        scanner.close();
    }
}