/**
 * The LoadedDie class simulates a weighted die.
 *
 * @author Mershelle Rivera
 * @version 1.0
 */

public class LoadedDie {
    // Class attributes
    private int favoredFace;    // The favored face of the die
    private int percentage;     // The percentage to represent more times per hundred

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
}
