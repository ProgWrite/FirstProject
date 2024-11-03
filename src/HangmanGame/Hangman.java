package HangmanGame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Scanner;
import static HangmanGame.drawHangmanState.*;

public class Hangman {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        startMenu();
    }


    public static void startMenu() {
        System.out.println("Введите 1 чтобы начать игру, введите 2 чтобы выйти из игры");
        String gameStatus = scanner.nextLine();
        if(gameStatus.equals("1")){
            gameplay(takeRandomWord());
        }
        else if(gameStatus.equals("2")){
            System.exit(0);
        }
        else{
            System.out.println("Вы ввели неверный символ!");
            startMenu();
        }
    }


    public static String takeRandomWord(){
        List<String> listWithWords = new ArrayList<>();
        String relativePath = "src\\HangmanGame\\words.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(relativePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                listWithWords.add(line);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        int randomIndex = random.nextInt(listWithWords.size());
        String randomWord = listWithWords.get(randomIndex);
        return randomWord;
    }


    public static void gameplay(String word){

        char [] randomWordToChars = new char[word.length()];
        for (int i = 0; i < randomWordToChars.length; i++){
            randomWordToChars[i] = '*';
        }
        int mistakes = 0;
        int countStars = 0;
        int rightLetter = 0;
        System.out.println("Введите любую букву русского алфавита, чтобы начать отгадывать слово");
        drawMan(0);
        ArrayList<String> enteredChars = new ArrayList <> ();

        INNER: while (mistakes < 6) {
            String input = scanner.nextLine().toLowerCase();
            if(checkLength(input) == false) {
                continue INNER;
            }

            if(enteredChars.contains(input) == true) {
                System.out.println("Вы уже вводили данную букву, пожалуйста, не повторяйтесь :)");
                continue INNER;
            }
            else{
                enteredChars.add(input);
            }

            char c = input.charAt(0);
            checkRussianChar(c);
            if (checkRussianChar(c) == false) {
                System.out.println("Неверно! Пожалуйста, вводите буквы только из русского алфавита");
                continue INNER;
            }

            // if all checks are passed, gameplay begins
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    randomWordToChars[i] = c;
                    rightLetter++;
                }
                else{
                    countStars++;
                }
                if(rightLetter == word.length()){
                    System.out.println("Поздравляю с победой! Вы верно угадали слово - " + word );
                    startMenu();
                    break INNER;
                }

            }


            if (countStars == word.length()) {
                mistakes++;
            }
            countStars = 0;
            System.out.print("Вы отгадываете слово - ");
            System.out.println(randomWordToChars);
            System.out.println("Общее количество ошибок: " + mistakes);
            System.out.println();
            drawMan(mistakes);
        }
        if (mistakes == 6) {
            System.out.println("Игра окончена - вы проиграли! Загаданное слово - " + "'" + word + "'");
            startMenu();
        }
    }

    public static boolean checkLength(String input) {
        boolean b = true;
        if (input.length() > 1) {
            System.out.println("Обратите внимание что допускается вводить только одну букву русского алфавита");
            b = false;
        }
        else if (input.isEmpty()) {
            System.out.println("Ввод не может быть пустым. Введите одну букву");
            b = false;
        }
        return b;
    }

    public static boolean checkRussianChar(char c) {
        boolean b = true;
        String s1 = Character.toString(c);
        b = !s1.isEmpty() && (s1 != null) && (s1.matches("^[а-яА-ЯёЁ]*$"));
        return b;
    }
}
