import java.util.Random;

/**
 * The LoadedDie class simulates a weighted die.
 *
 * @author Mershelle Rivera
 * @version 1.0
 */

public class LoadedDie {
    // Class constants
    private static final int SIDES = 6;     // 6 sides of a die
    private static final int RANGE = 100;   // Range to define the percentage dependent
                                            // on whether a die lands on a loaded side
    // Class attributes
    private final int favoredFace;    // The favored face of the die
    private final int percentage;     // The percentage to represent more times per hundred

    /**
     * The constructor performs an initial roll of the die.
     *
     * @param loadNumber            which number should come up more often
     * @param moreTimesPerHundred   how many times per 100 rolls to come up with
     *                              the loaded number (instead of uniform random)
     */
    public LoadedDie(int loadNumber, int moreTimesPerHundred) {
        favoredFace = loadNumber;
        percentage = moreTimesPerHundred;
    }

    /**
     * The roll method simulates the rolling of the die.
     * It will typically set this die's value to a random value
     * with uniform distribution between 1 and 6. Occasionally,
     * it will a priori return the favored value (with frequency
     * determined by the moreTimesPerHundred argument that was passed
     * to the constructor).
     */
    public int roll() {
        // Create a Random object to be used to randomize a percentage
        Random random = new Random();

        // Randomize a percentage
        int randomPercent = random.nextInt(RANGE);

        // If the randomPercent is less than the percentage determined in the constructor,
        // then assign dieValue to favoredFace
        // The die's value after a roll
        int dieValue;
        if (randomPercent < percentage)
            dieValue = favoredFace;
        else                                        // Otherwise, the randomly roll the die
            dieValue = random.nextInt(SIDES) + 1;   // to land on a value from 1-6.

        return dieValue;
    }
}
