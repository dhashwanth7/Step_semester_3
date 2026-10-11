package string.class_problems;

public class Scorecard {

    private final boolean[] answers;
    private int answerCount;

    public Scorecard(int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new IllegalArgumentException(
                "Total questions must be positive."
            );
        }

        answers = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answerCount < answers.length) {
            answers[answerCount] = isCorrect;
            answerCount++;
        } else {
            System.out.println("All answers have been recorded.");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (answers[i]) {
                score++;
            }
        }

        return score;
    }
}