package string.class_problems;

import java.util.Scanner;

abstract class TravelBooking {
    protected double distance;

    private static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 2500 + (distance * 4.0);
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            TravelBooking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;

                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;

                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;

                default:
                    System.out.println("Invalid travel mode");
                    continue;
            }

            System.out.printf(
                "%s: %.2f%n",
                mode,
                booking.calculateTotal()
            );
        }

        sc.close();
    }
}