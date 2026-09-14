package string.class_problems;

import java.util.Scanner;

public class CourseCreditManagement {

    static class Course {

        String code;
        String title;
        int credits;
        int labCredits;

        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String theoryCode = sc.nextLine();
        String theoryTitle = sc.nextLine();
        int theoryCredits = sc.nextInt();
        sc.nextLine();

        String labCode = sc.nextLine();
        String labTitle = sc.nextLine();
        int labCredits = sc.nextInt();
        int labComponent = sc.nextInt();

        Course theoryCourse = new Course(
                theoryCode,
                theoryTitle,
                theoryCredits
        );

        Course labCourse = new Course(
                labCode,
                labTitle,
                labCredits,
                labComponent
        );

        System.out.println(
                theoryCode + " total credits: " + theoryCourse.totalCredits()
        );

        System.out.println(
                labCode + " total credits: " + labCourse.totalCredits()
        );

        sc.close();
    }
}