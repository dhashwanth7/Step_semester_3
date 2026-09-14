package string.class_problems;

import java.util.Scanner;

public class StudentCollegeInformationManagement {

    static class Student {

        String name;
        double attendance;

        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name1 = sc.nextLine();
        double attendance1 = sc.nextDouble();
        sc.nextLine();

        String name2 = sc.nextLine();
        double attendance2 = sc.nextDouble();

        Student student1 = new Student(name1, attendance1);
        Student student2 = new Student(name2, attendance2);

        System.out.println("2 Student objects created");

        Student.printCollegeInfo();

        sc.close();
    }
}