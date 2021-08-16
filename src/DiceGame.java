import java.util.Scanner;

/**
 * This program is to use LoadedDie to create a rolling dice game between CPU and player.
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
    private static int rollCount = 1;   // Counts the number of rolls
    private static int playerRoll;      // The value of the player die
    private static int cpuWins;         // Counts the number of CPU wins
    private static int playerWins;      // Counts the number of player wins

    /**
     * This will start the application
     *
     * @param args  String arguments
     */
    public static void main(String[] args) {
        // Create LoadedDie objects for CPU and player
        LoadedDie cpuDie = new LoadedDie(CPU_FAVORED_FACE, PERCENTAGE);
        LoadedDie playerDie = new LoadedDie(PLAYER_FAVORED_FACE, PERCENTAGE);

        // Create Scanner object to take in user input
        Scanner scanner = new Scanner(System.in);

        intro();    // Print out the intro
        start(scanner, cpuDie, playerDie);    // Starts the game
    }

    /**
     * The welcome message of the game
     */
    public static void intro() {
        System.out.println("""
                This is a game of you versus the computer. We will each\s
                have one die. We roll our own die and the higher number\s
                wins. We roll ten times and the one with the higher number\s
                of wins is the grand winner.""");
        System.out.println();
    }

    /**
     * This methods starts the game
     */
    public static void start(Scanner scanner, LoadedDie cpuDie, LoadedDie playerDie) {
        String userInput;   // To hold console inputs from user

        while (rollCount <= MAX_ROLLS) {
            System.out.println("Roll " + rollCount + " of " + MAX_ROLLS + ":");
            // The value of CPU die
            int cpuRoll = cpuDie.roll();
            System.out.println("I rolled a " + cpuRoll);
            // Ask user if they want to roll
            System.out.print("Ready to roll? (Press ENTER when ready)");
            userInput = scanner.nextLine();

            // If the userInput is 'enter key'
            // continue if true, otherwise, end the game
            if (userInput.equals("")) {
                // If user presses the enter key
                playerRoll = playerDie.roll();
                System.out.println("You rolled a " + playerRoll);
                // Because player continued to play, the game count increments
                rollCount++;
                System.out.println();
            }

            // Count the wins by CPU/player
            if (cpuRoll > playerRoll)
                cpuWins++;
            else if (playerRoll > cpuRoll)
                playerWins++;
        }

        // Print out the game stats at the end of game
        System.out.println("I won " + cpuWins + " times.");
        System.out.println("You won " + playerWins + " times.");

        // Print out the winner of the game
        if (cpuWins > playerWins)
            System.out.println("Grand winner is me!");
        else
            System.out.println("Grand winner is you!");

        // Prompt user to play again
        System.out.print("Ready to play? (no to quit) ");
        userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("no")) {
            System.out.println();
            System.out.println("Thanks for playing!");
        }
    }
}
