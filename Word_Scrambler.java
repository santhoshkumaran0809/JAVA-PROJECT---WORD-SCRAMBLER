import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Word_Scrambler {

    private static final Random RANDOM = new Random();

    /**
     * Scrambles the input word by randomly swapping its characters.
     * @param word The word to be scrambled.
     * @return The scrambled word string.
     */
    public static String scrambleWord(String word) {
        // Convert the String to a char array so individual characters can be rearranged
        char[] chars = word.toCharArray(); 
        
        // Loop backward through the array
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
        System.out.println("--- Java Word Scrambler Demo ---");
        
        String originalWord = "PROGRAMMING";
        String scrambled = scrambleWord(originalWord);
        
        // Ensure the scrambled word is not accidentally the same as the original (very rare, but good practice)
        while (scrambled.equals(originalWord)) {
             scrambled = scrambleWord(originalWord);
        }
        
        System.out.println("\nOriginal Word: " + originalWord);
        System.out.println("Scrambled Word: " + scrambled);
        
        // --- Simple Unscrambling Logic ---
        Scanner scanner = new Scanner(System.in);
        System.out.print("Try to unscramble the word: ");
        String userGuess = scanner.nextLine().toUpperCase(); // Convert to uppercase for comparison

        // Check if the guess matches the original word
        if (userGuess.equals(originalWord)) {
            System.out.println("\nSUCCESS! You correctly unscrambled the word.");
        } else {
            System.out.println("\nINCORRECT. Your guess was '" + userGuess + "'. The correct word was '" + originalWord + "'.");
        }
        
        scanner.close();
    }
}
