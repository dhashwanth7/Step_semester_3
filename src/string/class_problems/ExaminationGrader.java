package string.class_problems;

import java.util.Scanner;

class Question {
    protected String correctAnswer;
    protected double points;

    public Question(String correctAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public double grade(String studentAnswer) {
        return 0;
    }
}

class MCQ extends Question {

    public MCQ(String correctAnswer, double points) {
        super(correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }
}

class TrueFalseQuestion extends Question {

    public TrueFalseQuestion(String correctAnswer, double points) {
        super(correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }
}

class EssayQuestion extends Question {

    public EssayQuestion(String correctAnswer, double points) {
        super(correctAnswer, points);
    }

    @Override
    public double grade(String studentAnswer) {
        String[] keywords = correctAnswer.split(",");
        int matches = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase().contains(
                    keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine().trim();
            String[] parts = line.split("\"");

            String type = parts[0].trim();
            String questionText = parts[1];
            String correctAnswer = parts[3];
            String studentAnswer = parts[5];
            double points = Double.parseDouble(parts[6].trim());

            Question question;

            switch (type.toUpperCase()) {
                case "MCQ":
                    question = new MCQ(correctAnswer, points);
                    break;

                case "TF":
                    question = new TrueFalseQuestion(
                            correctAnswer, points);
                    break;

                case "ESSAY":
                    question = new EssayQuestion(
                            correctAnswer, points);
                    break;

                default:
                    System.out.println("Invalid question type");
                    continue;
            }

            double score = question.grade(studentAnswer);

            System.out.printf("%s: %.2f%n", type, score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}