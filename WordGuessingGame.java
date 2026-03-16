import java.util.*;

public class WordGuessingGame {

    static String[] words = {
        "apple","banana","computer","keyboard","internet",
        "science","teacher","student","library","school",
        "program","language","system","network","monitor",
        "printer","memory","software","hardware","database",
        "engineer","developer","algorithm","variable","function",
        "object","class","method","compile","execute",
        "python","java","javascript","android","windows",
        "linux","server","client","security","encryption"
        // You can continue adding words here up to 5000
    };

    public static String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("=================================");
        System.out.println("       WORD GUESSING GAME");
        System.out.println("       Made by URSHITA ROY");
        System.out.println("=================================");

        while (playAgain) {

            String secretWord = getRandomWord();
            char[] guessedWord = new char[secretWord.length()];
            boolean[] guessedLetters = new boolean[26];

            int attempts = 5;
            int score = 0;

            Arrays.fill(guessedWord, '_');

            while (attempts > 0) {

                System.out.print("\nWord: ");
                for (char c : guessedWord) {
                    System.out.print(c + " ");
                }

                System.out.println("\nAttempts left: " + attempts);
                System.out.println("Score: " + score);

                System.out.print("Enter a letter: ");
                char letter = scanner.next().toLowerCase().charAt(0);

                if (guessedLetters[letter - 'a']) {
                    System.out.println("You already guessed this letter!");
                    continue;
                }

                guessedLetters[letter - 'a'] = true;

                boolean correct = false;

                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        guessedWord[i] = letter;
                        correct = true;
                    }
                }

                if (correct) {
                    score += 10;
                    System.out.println("Correct guess!");
                } else {
                    attempts--;
                    score -= 2;
                    System.out.println("Wrong guess!");
                }

                if (String.valueOf(guessedWord).equals(secretWord)) {
                    System.out.println("\n🎉 Congratulations! You guessed the word: " + secretWord);
                    System.out.println("Final Score: " + score);
                    break;
                }
            }

            if (attempts == 0) {
                System.out.println("\nGame Over!");
                System.out.println("The correct word was: " + secretWord);
            }

            System.out.print("\nPlay Again? (yes/no): ");
            String answer = scanner.next().toLowerCase();

            if (!answer.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        scanner.close();
    }
}
