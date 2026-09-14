package string.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;

        while (firstIndex < arr1.length
                && secondIndex < arr2.length) {

            if (arr1[firstIndex] <= arr2[secondIndex]) {
                result[resultIndex] = arr1[firstIndex];
                firstIndex++;
            } else {
                result[resultIndex] = arr2[secondIndex];
                secondIndex++;
            }

            resultIndex++;
        }

        while (firstIndex < arr1.length) {
            result[resultIndex] = arr1[firstIndex];
            firstIndex++;
            resultIndex++;
        }

        while (secondIndex < arr2.length) {
            result[resultIndex] = arr2[secondIndex];
            secondIndex++;
            resultIndex++;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int firstSize = scanner.nextInt();

        int[] arr1 = new int[firstSize];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < firstSize; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int secondSize = scanner.nextInt();

        int[] arr2 = new int[secondSize];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < secondSize; i++) {
            arr2[i] = scanner.nextInt();
        }

        int[] result = mergeSortedArrays(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(result));

        scanner.close();
    }
}