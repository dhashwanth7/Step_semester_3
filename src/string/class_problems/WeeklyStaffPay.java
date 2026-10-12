package string.class_problems;

import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Staff staff;

            switch (type) {
                case "FULLTIME":
                    double weeklySalary = sc.nextDouble();
                    staff = new FullTimeStaff(name, weeklySalary);
                    break;

                case "HOURLY":
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staff = new HourlyStaff(name, hours, rate);
                    break;

                case "INTERN":
                    double stipend = sc.nextDouble();
                    staff = new InternStaff(name, stipend);
                    break;

                default:
                    System.out.println("Invalid staff type");
                    continue;
            }

            double pay = staff.calculatePay();

            System.out.printf("%s: %.2f%n", staff.getName(), pay);

            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        sc.close();
    }
}