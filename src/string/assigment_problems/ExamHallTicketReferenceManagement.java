package string.assigment_problems;

import java.util.Scanner;

public class ExamHallTicketReferenceManagement {

    static class HallTicket {

        String studentName;
        int seatNumber;

        HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String studentName = sc.nextLine();
        int initialSeatNumber = sc.nextInt();
        int updatedSeatNumber = sc.nextInt();

        HallTicket priya = new HallTicket(
                studentName,
                initialSeatNumber
        );

        HallTicket copy = priya;

        copy.seatNumber = updatedSeatNumber;

        HallTicket separate = new HallTicket(
                studentName,
                updatedSeatNumber
        );

        System.out.println(
                studentName + "'s seatNumber (via first variable): "
                        + priya.seatNumber
        );

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println("separate == priya: " + (separate == priya));

        sc.close();
    }
}