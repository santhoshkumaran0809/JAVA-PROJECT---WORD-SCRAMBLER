import java.util.Random;
import java.util.Scanner;

public class WordScrambler {

    private static final String[] WORD_LIST = {
        "COMPUTER",
        "PROGRAMMING",
        "KEYBOARD",
        "ALGORITHM",
        "SOFTWARE",
        "DEVELOPER",
        "JAVASCRIPT",
        "DATABASE",
        "COMPILER",
        "FRAMEWORK",
        "VARIABLE",
        "FUNCTION",
        "BOOLEAN",
        "INTEGRATION"
    };

    private static final Random RANDOM = new Random();

    // Selects a random word
    public static String selectRandomWord() {
        int index = RANDOM.nextInt(WORD_LIST.length);
        return WORD_LIST[index];
    }

    // Scrambles the selected word
    public static String scrambleWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean keepPlaying = true;

        System.out.println("=====================================");
        System.out.println("   Welcome to the Java Word Scrambler");
        System.out.println("=====================================");

        while (keepPlaying) {
            String originalWord = selectRandomWord();
            String scrambled = scrambleWord(originalWord);

            // Re-scramble if it's the same as the original
            while (scrambled.equalsIgnoreCase(originalWord)) {
                scrambled = scrambleWord(originalWord);
            }

            System.out.println("\n--- New Round ---");
            System.out.println("Your current score: " + score);
            System.out.println("Word has " + originalWord.length() + " letters.");
            System.out.println("Scrambled Word: " + scrambled);
            System.out.println("-------------------------------------");

            System.out.print("Enter your guess (or type 'quit' to exit): ");
            String userGuess = scanner.nextLine().trim();

            // Case-insensitive quit command
            if (userGuess.equalsIgnoreCase("quit")) {
                keepPlaying = false;
                continue;
            }

            // Case-insensitive comparison
            if (userGuess.equalsIgnoreCase(originalWord)) {
                score++;
                System.out.println("✅ Correct! The word was " + originalWord + ".");
            } else {
                System.out.println("❌ Incorrect! The correct word was: " + originalWord + ".");
            }
        }

        System.out.println("\n=====================================");
        System.out.println("           GAME OVER!");
        System.out.println(" Your Final Score: " + score);
        System.out.println("=====================================");

        scanner.close();
    }
}
