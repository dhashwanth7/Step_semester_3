package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String getComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        return moves[random.nextInt(moves.length)];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Rock-Paper-Scissors Game");

        for (int round = 1; round <= rounds; round++) {

            System.out.print("\nRound " + round +
                    " - Enter Rock, Paper, or Scissors: ");

            String playerMove = scanner.nextLine();

            String computerMove = getComputerMove();

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("\n----- Final Scoreboard -----");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");

        scanner.close();
    }
}