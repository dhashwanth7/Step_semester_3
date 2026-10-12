package string.assigment_problems;

import java.util.Arrays;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        String[] rotated = new String[n];

        k = k % n;

        for (int i = 0; i < n; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int k = 2;

        String[] result = rotateRoster(names, k);

        System.out.println(Arrays.toString(result));
    }
}