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

    /**
     * The start of the game
     *
     * @param args  String arguments
     */
    public static void main(String[] args) {
        // Print out the intro
        intro();
    }

    /**
     * The welcome message of the game
     */
    public static void intro() {
        System.out.println("This is a game of you versus the computer. We will each \n" +
                           "have one die. We roll our own die and the higher number \n" +
                           "wins. We roll ten times and the one with the higher number \n" +
                           "of wins is the grand winner.");
    }
}
