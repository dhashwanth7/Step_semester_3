package string.assigment_problems;

import java.util.Scanner;

public class PayrollSalaryManagement {

    static class PayrollAccount {

        private double basicSalary;
        private double bonus;

        public PayrollAccount(double basicSalary) {
            if (basicSalary < 0) {
                System.out.println(
                        "Warning: Negative basic salary. Starting with 0."
                );
                this.basicSalary = 0;
            } else {
                this.basicSalary = basicSalary;
            }

            this.bonus = 0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println(
                        "Bonus rejected: amount must be positive"
                );
            } else {
                bonus += amount;
                System.out.println("Bonus credited: Rs " + amount);
            }
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println(
                        "Tax rejected: percent must be between 0 and 100"
                );
            } else {
                basicSalary -= basicSalary * percent / 100;
                System.out.println("Tax deducted: " + percent + "%");
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double basicSalary = sc.nextDouble();
        double bonusAmount = sc.nextDouble();
        double taxPercent = sc.nextDouble();

        PayrollAccount account = new PayrollAccount(basicSalary);

        account.creditBonus(bonusAmount);
        account.deductTax(taxPercent);

        System.out.println("Net salary: Rs " + account.getNetSalary());

        sc.close();
    }
}