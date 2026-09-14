package string.class_problems;

import java.util.Scanner;

public class StudentPlacementRecordManagement {

    static class PlacementRecord {

        String studentName;
        String company;
        double packageLpa;

        PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        void printRecord() {
            System.out.println(
                    studentName + " -> " + company + " @ " + packageLpa + " LPA"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PlacementRecord[] records = new PlacementRecord[3];

        for (int i = 0; i < records.length; i++) {

            String studentName = sc.nextLine();
            String company = sc.nextLine();
            double packageLpa = sc.nextDouble();
            sc.nextLine();

            records[i] = new PlacementRecord(
                    studentName,
                    company,
                    packageLpa
            );
        }

        for (PlacementRecord record : records) {
            record.printRecord();
        }

        sc.close();
    }
}