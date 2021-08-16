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
    private static final int USER_FAVORED_FACE = 1;     // The user's favored face
    private static final int PERCENTAGE = 30;           // The percentage the dice will land on a favored face
    private static final int MAX_ROLLS = 10;            // Maximum of 10 rolls per game played

    // Class Attributes
    private static int cpuWins;         // Counts the number of CPU wins
    private static int userWins;      // Counts the number of player wins

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

        int rollCount = 1;                               // Counts the number of rolls
        start(scanner, cpuDie, playerDie, rollCount);    // Starts the game
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
     * @param userDie LoadedDie object to represent the user's die
     */
    public static void start(Scanner scanner, LoadedDie cpuDie, LoadedDie userDie, int rollCount) {
        intro();    // Print out the intro
        cpuWins = 0;
        userWins = 0;
        // Have the game run until 10 rolls
        while (rollCount <= MAX_ROLLS) {
            System.out.println();
            // Print the roll count of the game
            System.out.println("Roll " + rollCount + " of " + MAX_ROLLS + ":");
            // CPU rolls die, then the user will roll die
            int cpuRoll = cpuTurn(cpuDie);
            int userRoll = userTurn(scanner, userDie);
            if (userRoll < 1)
                rollCount = 11; // To get out of while loop

            // Because player continued to play, the game count increments
            rollCount++;
            // Count the wins by CPU/player
            if (cpuRoll > userRoll)
                cpuWins++;
            else if (userRoll > cpuRoll)
                userWins++;
        }

        gameStats();           // Print the game stats
        printWinner();         // Prints the winner of the game
        int answer = playAgain(scanner);    // Ask user if ready to play (again)
        if (answer == 1)
            goodbye();
        else
            start(scanner, cpuDie, userDie, 1);
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
        System.out.println("You won " + userWins + " times.");
    }

    /**
     * This method will print the winner of the game
     */
    public static void printWinner() {
        // Print out the winner of the game
        if (cpuWins > userWins)
            System.out.println("Grand winner is me!");
        else if (cpuWins == userWins)
            System.out.println("It's a tie!");
        else
            System.out.println("Grand winner is you!");
    }

    /**
     * This method is to prompt the user to play again
     * returns 0 if yes, 1 if no
     */
    public static int playAgain(Scanner scanner) {
        int answer = 0;
        String userInput;   // To hold console inputs from user
        // Prompt user to play again
        System.out.print("Ready to play? (no to quit) ");
        userInput = scanner.nextLine().toLowerCase();
        if (userInput.equals("no"))
            answer = 1;

        return answer;
    }

    /**
     * This method is to print 'goodbye'
     */
    public static void goodbye() {
        System.out.println("Thanks for playing!");
    }
}
