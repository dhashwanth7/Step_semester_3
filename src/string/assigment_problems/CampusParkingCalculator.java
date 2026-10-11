package string.class_problems;

import java.util.Scanner;

class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public double calculateCharge() {
        return 0;
    }
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return 10.0 * hours;
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return 30.0 + (20.0 * (hours - 1));
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return Math.max(50.0 * hours, 100.0);
    }
}

public class CampusParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;

                case "CAR":
                    vehicle = new Car(hours);
                    break;

                case "TRUCK":
                    vehicle = new Truck(hours);
                    break;

                default:
                    System.out.println("Invalid vehicle type");
                    continue;
            }

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", type, charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}