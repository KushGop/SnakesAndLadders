package SnL;

/**
 * 
 * @author Kush Gopeechund
 *
 */
public class LadderSquare extends SorLSquare {

	/**
	 * Checks whether the inputed value is a ladder.
	 * 
	 * @param number
	 * @param endSquare
	 */
	public LadderSquare(int number, int endSquare) {
		super(number, endSquare);
		if (number > endSquare)
			throw new IllegalArgumentException("Invalid");
	}

	/**
	 * Prints out a statement to show player has landed on a ladder.
	 * 
	 * @return an integer of the square to land on
	 */
	@Override
	public int landOn() {
		System.out.println("Yay!");
		return super.landOn();	//Override to replace normal square output with ladder output
	}

	/**
	 * Makes a squares string in a different format to represent a ladder.
	 * 
	 * @return a string of the square and the connected square from the ladder
	 */
	@Override
	public String toString() {
		super.toString();	//Override to replace normal square with a ladder
		return getNumber() + "+" + getEndSquare();
	}
}
