import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Game {
    private Timer timer;
    private Repository repository;
    public static boolean over;

    public Game() {
        over = false;
        this.timer = new Timer();
        this.repository = new Repository();

        this.timer.schedule(new GameOver(), 10000);
    }

    public void play() {
        this.timer = new Timer();
        Random randomNumber = new Random();
        String[] operators = {"+", "-", "*", "/"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = scanner.next();

        int rightAnswers = 0;
        int totalAnswers = 0;

        while(!over) {
            int firstNumber = randomNumber.nextInt(51);
            int secondNumber = randomNumber.nextInt(51);

            String operator = operators[randomNumber.nextInt(4)];


            if(operator == "+") {
                System.out.println(firstNumber + " + " + secondNumber);
                int soma = firstNumber + secondNumber;
                System.out.println("Answer: ");
                int userResult = scanner.nextInt();

                if (soma == userResult) {
                    rightAnswers ++;
                }

            } else if (operator == "-"){
                System.out.println(firstNumber + " - " + secondNumber);
                System.out.println("Answer: ");
                int userResult = scanner.nextInt();
                int sub = firstNumber - secondNumber;

                if (sub == userResult) {
                    rightAnswers ++;
                }

            } else if (operator == "*") {
                System.out.println(firstNumber + " * " + secondNumber);
                System.out.println("Answer: ");
                int userResult = scanner.nextInt();
                int mult = firstNumber * secondNumber;

                if (mult == userResult) {
                    rightAnswers ++;
                }

            } else if (operator == "/") {
                System.out.println(firstNumber + " / " + secondNumber);
                System.out.println("Answer: ");
                int userResult = scanner.nextInt();
                int div = firstNumber / secondNumber;

                if (div == userResult) {
                    rightAnswers ++;
                }
            }

        }

        this.repository.createRecord(name, rightAnswers);
        this.showUserResult(rightAnswers, totalAnswers);
        this.showBetterRecords();

        this.exit();
    }

    private void showBetterRecords() {
        ArrayList<Record> betterRecords = this.repository.getBetterRecords();

        System.out.println("\n\nRecords atuais");

        for (int i = 0; i < betterRecords.size(); i++) {
            Record record = betterRecords.get(i);

            System.out.println(i + 1 + " | " + record.getUsername() + " -> " + record.getPoints());
        }
    }

    private void showUserResult(int rightAnswers, int totalAnswers) {
        System.out.println("\n\nFinished!!");
        System.out.println("Total questions: " + totalAnswers);
        System.out.println("Total right answers: " + rightAnswers);
    }

    private void exit() {
        System.exit(0);
    }
}
