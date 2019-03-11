package SnL;

/**
 * 
 * @author Kush Gopeechund
 *
 */
public class SorLSquare extends SnLSquare {

	private int endSquare;

	/**
	 * Initializes the end square of snake or ladder.
	 * 
	 * @param number
	 * @param endSquare
	 */
	public SorLSquare(int number, int endSquare) {
		super(number);
		this.endSquare = endSquare;
		if (this.endSquare == getNumber())
			throw new IllegalArgumentException("Not a snake or ladder");
	}

	/**
	 * Returns the end of a snake or ladder.
	 * 
	 * @return integer of the end of a snake or ladder
	 */
	public int getEndSquare() {
		return endSquare;
	}

	/**
	 * Returns the square to land on when on a snake or ladder.
	 * 
	 * @return integer of the square to land on
	 */
	public int landOn() {
		return endSquare;
	}

	/**
	 * Returns the connected squares between a snake or ladder.
	 * 
	 * @return a string of the square and the square it's connected to
	 */
	public String toString() {
		return super.toString() + ":" + this.endSquare;
	}

	/**
	 * Used an override because there's no need the rewrite everything in SnLSquare.
	 * Only one this is added to compare other objects to SorLSquare.
	 * 
	 * @return a boolean whether another object is equal to this object
	 */
	@Override
	public boolean equals(Object o) {
		super.equals(o);
		return super.equals(o) && this.getEndSquare() == ((SorLSquare) (o)).getEndSquare();
	}
}
