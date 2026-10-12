package string.class_problems;

import java.util.Scanner;

abstract class Cab {
    protected double distance;

    public Cab(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public double calculateFare() {
        return Math.max(100.0, calculateBaseFare());
    }
}

interface NightService {
    double applyNightCharge(double fare);
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 14.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 18.0;
    }

    @Override
    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(distance);
                    break;

                case "SEDAN":
                    cab = new SedanCab(distance);
                    break;

                case "SUV":
                    cab = new SUVCab(distance);
                    break;

                default:
                    System.out.println("Invalid cab type");
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                NightService nightCab = (NightService) cab;
                fare = nightCab.applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}