package string.assigment_problems;

import java.util.Scanner;

public class EmployeeCompanyInformationManagement {

    static class Employee {

        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name1 = sc.nextLine();
        double salary1 = sc.nextDouble();
        sc.nextLine();

        String name2 = sc.nextLine();
        double salary2 = sc.nextDouble();
        sc.nextLine();

        String name3 = sc.nextLine();
        double salary3 = sc.nextDouble();

        Employee employee1 = new Employee(name1, salary1);
        Employee employee2 = new Employee(name2, salary2);
        Employee employee3 = new Employee(name3, salary3);

        System.out.println("3 Employee objects created");

        Employee.printCompanyInfo();

        sc.close();
    }
}