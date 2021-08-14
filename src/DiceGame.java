import java.util.Scanner;

/**
 * This program is to use LoadedDie to create a rolling dice game between CPU and player
 *
 * @author Mershelle Rivera
 * @version 1.0
 */
public class DiceGame {
    // Class Constants
    private static final int CPU_FAVORED_FACE = 6;      // The CPU's favored face
    private static final int PLAYER_FAVORED_FACE = 1;   // The user's favored face
    private static final int PERCENTAGE = 30;           // The percentage the dice will land on a favored face
    private static final int MAX_ROLLS = 10;            // Maximum of 10 rolls per game played

    // Class Attributes
    private static int rollCount = 1;  // Counts the number of rolls

    /**
     * The start of the game
     *
     * @param args  String arguments
     */
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);   // Will be taking in scanner inputs from
                                                    // player (Scanner input)
        String userInput = "";

        // Create LoadedDie objects for CPU and player
        LoadedDie cpuDie = new LoadedDie(CPU_FAVORED_FACE, PERCENTAGE);
        LoadedDie playerDie = new LoadedDie(PLAYER_FAVORED_FACE, PERCENTAGE);

        // Print out the intro
        intro();

        while (rollCount <= MAX_ROLLS) {
            System.out.println("Roll " + rollCount + " of " + MAX_ROLLS + ":");
            System.out.println("I rolled a " + cpuDie.roll());
            // Ask user if they want to roll
            System.out.print("Ready to roll? (Press ENTER when ready)");
            userInput = scanner.nextLine();

            // If the userInput is 'enter key'
            // continue if true, otherwise, end the game
            if (userInput.equals("")) {
                // If user presses the enter key
                System.out.println("You rolled a " + playerDie.roll());
                // Because player continued to play, the game count increments
                rollCount++;
                System.out.println();
            }

        }
    }

    /**
     * The welcome message of the game
     */
    public static void intro() {
        System.out.println("This is a game of you versus the computer. We will each \n" +
                           "have one die. We roll our own die and the higher number \n" +
                           "wins. We roll ten times and the one with the higher number \n" +
                           "of wins is the grand winner.");
        System.out.println();
    }
}