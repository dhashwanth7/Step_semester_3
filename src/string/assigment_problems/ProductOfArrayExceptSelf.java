package string.assigment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int leftProduct = 1;

        // Forward pass: store product of elements to the left
        for (int i = 0; i < nums.length; i++) {

            answer[i] = leftProduct;

            leftProduct = leftProduct * nums[i];
        }

        int rightProduct = 1;

        // Backward pass: multiply by product of elements to the right
        for (int i = nums.length - 1; i >= 0; i--) {

            answer[i] = answer[i] * rightProduct;

            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Error: Array must contain at least 2 elements.");
        } else {

            int[] nums = new int[n];

            System.out.println("Enter array elements:");

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int[] result = productExceptSelf(nums);

            System.out.println("Product Except Self: "
                    + Arrays.toString(result));
        }

        scanner.close();
    }
}