import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestion();
    }

    private void loadQuestion() {
        questions.add(new Question("What is the capital of India?",
                new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 2));
        questions.add(new Question("Which language runs on JVM?",
                new String[]{"C", "Python", "Java", "JavaScript"}, 3));
        questions.add(new Question("Which company owns Android?",
                new String[]{"Apple", "Microsoft", "Google", "Samsung"}, 3));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question q : questions) {
            q.displayQuestion();
            System.out.println("Enter Your Answer (1-4):");
            int answer = scanner.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("Correct ✅");
                score++;
            }else{
                System.out.println("Incorrect ❌");
            }
        }
        System.out.println("quiz over");
        System.out.println("your score:"+score);
        scanner.close();
    }
}
