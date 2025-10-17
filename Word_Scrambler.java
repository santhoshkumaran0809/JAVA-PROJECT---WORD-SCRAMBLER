import java.util.Random;
import java.util.Scanner;

public class Word_Scrambler {

    // 1. Array of words to be randomly selected for the game.
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
    
    // Random object for shuffling and word selection
    private static final Random RANDOM = new Random();

    /**
     * Selects a random word from the WORD_LIST.
     * @return A randomly chosen word in uppercase.
     */
    public static String selectRandomWord() {
        int index = RANDOM.nextInt(WORD_LIST.length);
        return WORD_LIST[index];
    }

    /**
     * Scrambles the input word using the Fisher-Yates Shuffle.
     * @param word The word to be scrambled.
     * @return The scrambled word string.
     */
    public static String scrambleWord(String word) {
        // Convert the String to a char array so individual characters can be rearranged
        char[] chars = word.toCharArray();
        
        // Loop backward through the array (Fisher-Yates Shuffle)
        for (int i = chars.length - 1; i > 0; i--) {
            // Pick a random index j between 0 and i (inclusive)
            int j = RANDOM.nextInt(i + 1);
            
            // Swap the characters at position i and j
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        
        // Convert the modified char array back into a String
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean keepPlaying = true;

        System.out.println("=====================================");
        System.out.println("  Welcome to the Java Word Scrambler ");
        System.out.println("=====================================");
        
        while (keepPlaying) {
            
            // 1. Select a random word from the list
            String originalWord = selectRandomWord();
            
            // 2. Scramble the word
            String scrambled = scrambleWord(originalWord);
            
            // 3. Re-scramble if it accidentally resulted in the original word
            while (scrambled.equals(originalWord)) {
                scrambled = scrambleWord(originalWord);
            }
            
            // Display the current challenge
            System.out.println("\n--- Round Start | Current Score: " + score + " ---");
            System.out.println("Your challenge word has " + originalWord.length() + " letters.");
            System.out.println("Scrambled Word: " + scrambled);
            System.out.println("-------------------------------------");

            // Get the user's guess
            System.out.print("Try to unscramble (or type 'QUIT' to end): ");
            String userGuess = scanner.nextLine().toUpperCase();

            if (userGuess.equals("QUIT")) {
                keepPlaying = false;
                continue; // Skip the rest of the loop and go to the final score display
            }

            // Check if the guess matches the original word
            if (userGuess.equals(originalWord)) {
                score++; // Increase score for a correct guess
                System.out.println("\n CORRECT! The word was " + originalWord + ".");
                System.out.println("Your score is now: " + score);
            } else {
                System.out.println("\n INCORRECT. Your guess was '" + userGuess + "'.");
                System.out.println("The correct word was: '" + originalWord + "'.");
                // Optional: You could reset the score here if you wanted a more challenging game.
            }
        }
        
        // Game Over Summary
        System.out.println("=====================================");
        System.out.println("        G A M E   O V E R          ");
        System.out.println("  Final Score: " + score + " Correct Guesses");
        System.out.println("=====================================");
        
        scanner.close();
    }
}
