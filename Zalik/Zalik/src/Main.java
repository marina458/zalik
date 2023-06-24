import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        List<Question> questions = new ArrayList<>();


        questions.add(new Question("Я здам залік сьогодні???",
                new ArrayList<>(Arrays.asList("Ні", "Звичайно так ", "Якщо постараєшся ","Навіть не думай ")), "2"));
        questions.add(new Question("Яку оцінку отримаєш?",
                new ArrayList<>(Arrays.asList("Задовільну ", "Найкращу для тебе ", "Відмінно","Добре")), "2"));
        questions.add(new Question("Як оціните роботу викладача на цій дисципліні?",
                new ArrayList<>(Arrays.asList("Сподобалось,але можна краще ", "Для початку добре", "Чудово", "Найкраща дисципліна(Після БД) і викладач!!!!")), "4"));
        questions.add(new Question("Що вам не сподобалось?",
                new ArrayList<>(Arrays.asList("Все сподобалось все добре", "Все не сподобалось", "Офігенно","Все погано")), "1"));
        questions.add(new Question("Що не так??",
                new ArrayList<>(Arrays.asList("Все гуд", "Отлічно", "Все так,все чудово","Все не так")), "3"));

        Test test = new Test(questions);



        test.showTest();
    }


    private static class Question {

        private String _question;
        private List<String> _questions;
        private String _correctAnswer;

        public Question(String question, List<String> questions, String correctAnswer) {
            _question = question;
            _questions = questions;
            _correctAnswer = correctAnswer;
        }

        public Question() {

        }

        public boolean askQuestion() {
            System.out.println(_question);
            Scanner scanner = new Scanner(System.in);
            for (Integer i = 0; i < _questions.size(); i++) {
                System.out.println((i + 1) + ") " + _questions.get(i));

            }
            System.out.println("Сhoose the answer(number):");
            String userAnswer = "";
            while (true) {
                userAnswer = scanner.nextLine();
                if (Integer.parseInt(userAnswer)<5 && Integer.parseInt(userAnswer)>0 ){
                    break;
                }
                else {
                    System.out.println("I don't know this " +userAnswer + " please choose answer");

                }
            }

            if (userAnswer.equals(_correctAnswer)) {
                return true;
            }

            return false;

        }

    }

    private static class Test {
        private List<Question> questions;

        public Test(List<Question> questions) {
            this.questions = questions;
        }

        public void showTest() {
            Integer correctAnswers = 0;
            for (Question q : questions) {
                if (q.askQuestion())
                    correctAnswers++;
            }

            System.out.println("You answered " + (correctAnswers) + " out of " + questions.size() + " questions");
        }
    }
}
