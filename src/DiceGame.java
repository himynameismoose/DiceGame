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
    private static final int USER_FAVORED_FACE = 1;   // The user's favored face
    private static final int PERCENTAGE = 30;           // The percentage the dice will land on a favored face
    private static final int MAX_ROLLS = 10;            // Maximum of 10 rolls per game played

    // Class Attributes
    private static int rollCount = 1;   // Counts the number of rolls
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
        LoadedDie playerDie = new LoadedDie(USER_FAVORED_FACE, PERCENTAGE);

        // Create Scanner object to take in user input
        Scanner scanner = new Scanner(System.in);

        intro();    // Print out the intro
        start(scanner, cpuDie, playerDie);    // Starts the game
    }

    /**
     * The welcome message of the game
     */
    public static void intro() {
        System.out.println();
        System.out.println("""
                This is a game of you versus the computer. We will each\s
                have one die. We roll our own die and the higher number\s
                wins. We roll ten times and the one with the higher number\s
                of wins is the grand winner.""");
    }

    /**
     * This methods starts the game
     *
     * @param scanner To read user inputs in the console
     * @param cpuDie LoadedDie object to represent the CPU's die
     * @param playerDie LoadedDie object to represent the user's die
     */
    public static void start(Scanner scanner, LoadedDie cpuDie, LoadedDie playerDie) {
        String userInput;   // To hold console inputs from user

        // Have the game run until 10 rolls
        while (rollCount <= MAX_ROLLS) {
            System.out.println();
            // Print the roll count of the game
            System.out.println("Roll " + rollCount + " of " + MAX_ROLLS + ":");
            // CPU rolls die, then the user will roll die
            int cpuRoll = cpuTurn(cpuDie);
            int userRoll = userTurn(scanner, playerDie);
            if (userRoll < 1) {
                rollCount = 11; // To get out of while loop
            }
            // Because player continued to play, the game count increments
            rollCount++;
            // Count the wins by CPU/player
            if (cpuRoll > userRoll)
                cpuWins++;
            else if (userRoll > cpuRoll)
                playerWins++;
        }

        gameStats();    // Print the game stats
        printWinner();  // Prints the winner of the game

        // Prompt user to play again
        System.out.print("Ready to play? (no to quit) ");
        userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("no")) {
            System.out.println();
            System.out.println("Thanks for playing!");
        }
    }

    /**
     * This method will roll the dice for the CPU and will return the die value
     *
     * @param cpuDie The LoadedDie object to represent the CPU die
     */
    public static int cpuTurn(LoadedDie cpuDie) {
        int cpuRoll = cpuDie.roll();    // The value of CPU die
        System.out.println("I rolled a " + cpuRoll);

        return cpuRoll;
    }

    /**
     * This method will roll the dice for the user if wished to continue
     * and returns the value of the die. If the user does not wish to continue,
     * the method will return -1.
     *
     * @param scanner To read user inputs from console
     * @param userDie LoadedDie object to represent the user's die
     */
    public static int userTurn(Scanner scanner, LoadedDie userDie) {
        String userInput;   // To hold console inputs from user
        int userRoll;       // To hold the value of the user's die

        // Ask user if they want to roll
        System.out.print("Ready to roll? (Press ENTER when ready)");
        userInput = scanner.nextLine();

        // If the userInput is 'enter key'
        if (userInput.equals("")) {
            // If user presses the enter key
            userRoll = userDie.roll();
            System.out.println("You rolled a " + userRoll);
        } else {    // If the userInput is not 'enter key'
            userRoll = -1;  // Returns a non-die value
        }

        return userRoll;
    }

    /**
     * This method will print the game stats
     */
    public static void gameStats() {
        // Print out the game stats at the end of game
        System.out.println("I won " + cpuWins + " times.");
        System.out.println("You won " + playerWins + " times.");
    }

    /**
     * This method will print the winner of the game
     */
    public static void printWinner() {
        // Print out the winner of the game
        if (cpuWins > playerWins)
            System.out.println("Grand winner is me!");
        else if (cpuWins == playerWins)
            System.out.println("It's a tie!");
        else
            System.out.println("Grand winner is you!");
    }
}
