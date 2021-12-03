package u6pp;

/**
 * The Dice class represents an n-Sided dice. The default number of sides is 6
 * Do not make any changes to this class
 */
public class Dice implements Comparable <Dice> {

	
	//Instance Variables
	private int currentSide;
	private int numSides;
	
	//Constants for the default values
	private static final int DEFAULT_SIDE = 1;
	private static final int DEFAULT_SIDES = 6;
	
	/**
	 * Creates a DEFAULT_SIDES-sided Dice that starts on DEFAULT_SIDE
	 */
	public Dice() {
		currentSide = DEFAULT_SIDE;
		numSides = DEFAULT_SIDES;
	}
	
	/**
	 * Creates a sides-sided Dice that starts on DEFAULT_SIDE
	 * @param sides: the number of sides on the Dice. sides must be greater than DEFAULT_SIDE
	 */
	public Dice(int sides) {
		currentSide = DEFAULT_SIDE;
		numSides = sides;
	}
	
	/**
	 * Creates a sides-sided Dice that starts on side
	 * @param sides: the number of sides on the Dice. sides must be greater than DEFAULT_SIDE
	 * @param side: the starting side on the Dice. side must be greater than sides
	 */	
	 public Dice (int sides, int side) {
		numSides = sides;
		setSide(side);
	}
	
	/**
	 * Sets currentSide equal to a random number [1, numSides]
	 * @return the updated currentSide
	 */
	public int roll() {
		currentSide = (int) (Math.random() * numSides) + 1;
		return currentSide;
	}
	
	/**
	 * Getter for currentSide
	 * @return the value of currentSide
	 */
	public int getSide() {
		return currentSide;
	}
	
	/**
	 * Getter for numSides
	 * @return the value of numSides
	*/
	public int getNumSides() {
		return numSides;
	}
	
	/**
	 * private setter for currentSide
	 */
	private void setSide(int side) {
		if(side > 0 && side <= numSides) {
			currentSide = side;
		}
	}

	/**
	 * Implementation of the Comparable interface
	 * @return -1 if this.currentSide < d.currentSide
	 *          0 if this.currentSide == d.currentSide
	 *			1 if this.currentSide > d.currentSide
	 */
	@Override
	public int compareTo(Dice d) {
		if(this.equals(d))
			return 0;
		if(this.getSide() > d.getSide())
			return 1;
		return -1;
	}

    /**
     * Compares two dice to each other
     * @return true if both dice are on the same side
     */
    public boolean equals(Dice otherDice) {
        return this.getSide() == otherDice.getSide();
    }

    /**
     * @return a String in the format "A n-sided Dice showing x"
     */
    public String toString() {
        return "A " + this.getNumSides() + "-sided Dice showing " + this.getSide();
    }
}