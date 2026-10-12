package string.class_problems;

import java.util.Scanner;

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPower();

    public double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
}

interface SaverMode {
    double applySaver(double units);
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 150.0;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 1500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 100.0;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours) {
        super(hours);
    }

    @Override
    public double getPower() {
        return 500.0;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saverRequested = false;

            if (sc.hasNext()) {
                String next = sc.next();

                if (next.equalsIgnoreCase("SAVER")) {
                    saverRequested = true;
                } else {
                    System.out.println("Invalid option: " + next);
                    continue;
                }
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AirConditioner(hours);
                    break;

                case "TV":
                    appliance = new Television(hours);
                    break;

                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;

                default:
                    System.out.println("Invalid appliance type");
                    continue;
            }

            if (saverRequested && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested) {
                SaverMode saver = (SaverMode) appliance;
                units = saver.applySaver(units);
            }

            double cost = units * 8.0;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}