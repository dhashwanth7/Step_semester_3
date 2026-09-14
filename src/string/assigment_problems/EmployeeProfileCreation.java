package string.assigment_problems;

import java.util.Scanner;

public class EmployeeProfileCreation {

    static class Employee {

        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        public Employee(String empId, String empName) {
            this(empId, empName, 0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(
                    empId + " | " + empName
                            + " | Rs " + salary
                            + " | Intern: " + isIntern
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String permanentId = sc.nextLine();
        String permanentName = sc.nextLine();
        double permanentSalary = sc.nextDouble();
        sc.nextLine();

        String internId = sc.nextLine();
        String internName = sc.nextLine();

        Employee permanentEmployee = new Employee(
                permanentId,
                permanentName,
                permanentSalary
        );

        Employee internEmployee = new Employee(
                internId,
                internName
        );

        permanentEmployee.printProfile();
        internEmployee.printProfile();

        sc.close();
    }
}