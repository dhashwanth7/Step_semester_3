package string.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public double getCompositeScore() {
            return (cgpa * 10) + codingScore;
        }

        public String getName() {
            return name;
        }

        static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }

        @Override
        public int compareTo(Candidate other) {
            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (Candidate candidate : candidates) {

            if (Candidate.isEligible(candidate.cgpa)
                    || Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shortlisted.length; i++) {

            result.append(i + 1)
                    .append(". ")
                    .append(shortlisted[i].getName())
                    .append(" (")
                    .append(shortlisted[i].getCompositeScore())
                    .append(")");

            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            String name = sc.nextLine();
            double cgpa = sc.nextDouble();
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println(shortlistAndRank(candidates));

        sc.close();
    }
}