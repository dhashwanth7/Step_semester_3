package string.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {

        if (nums.length == 0) {
            return nums;
        }

        k = k % nums.length;

        int[] rotatedArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int newPosition = (i + k) % nums.length;

            rotatedArray[newPosition] = nums[i];
        }

        return rotatedArray;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter rotation count: ");
        int k = scanner.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(result));

        scanner.close();
    }
}