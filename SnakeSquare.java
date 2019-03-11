package SnL;

/**
 * 
 * @author Kush Gopeechund
 *
 */
public class SnakeSquare extends SorLSquare {

	/**
	 * Checks whether the inputed value is a snake.
	 * 
	 * @param number
	 * @param endSquare
	 */
	public SnakeSquare(int number, int endSquare) {
		super(number, endSquare);
		if (number < endSquare)
			throw new IllegalArgumentException("Invalid");
	}

	/**
	 * Prints out a statement to show player has landed on a snake.
	 * 
	 * @return an integer of the square to land on
	 */
	@Override
	public int landOn() {
		System.out.println("Oh no!");
		return super.landOn(); //Override to replace normal square output with snake output
	}

	/**
	 * Makes a squares string in a different format to represent a snake.
	 * 
	 * @return a string of the square and the connected square from the snake
	 */
	@Override
	public String toString() {
		super.toString();	//Override to replace normal square with a snake
		return getNumber() + "-" + getEndSquare();
	}
}
