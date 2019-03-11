package SnL;

/**
 * 
 * @author Kush Gopeechund
 *
 */
public class SnLSquare {

	private int number;

	/**
	 * Initializes a value to a square on the game board.
	 * 
	 * @param number
	 */
	public SnLSquare(int number) {
		this.number = number;
	}

	/**
	 * Returns the number of the square.
	 * 
	 * @return a integer of the squares number
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * Returns the number of the square to land on.
	 * 
	 * @return a integer of the square to land on
	 */
	public int landOn() {
		return this.number;
	}

	/**
	 * Returns the squares number.
	 * 
	 * @return a string of the square
	 */
	public String toString() {
		return Integer.toString(this.number);
	}

	/**
	 * Checks if an object is equal to this object. Returns true if equal, false if
	 * not equal
	 * 
	 * @return a boolean of whether the object being compared is the same as this
	 *         object
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		SnLSquare c = (SnLSquare) o;
		return (this.number == c.number && this.getNumber() == c.getNumber());
	}

}
