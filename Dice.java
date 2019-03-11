package SnL;

import java.util.Date;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author Kush
 *
 */

/*
 * This program allows a client to roll a specific number of die
 */

public class Dice {

	private int[] dice;
	Random random;

	public Dice() {		//Sets default number of die to 2
		this(2);
	}

	public Dice(int numDice) {		//Checks for invalid input (negative value) when setting number of die
		if (numDice < 1)
			throw new IllegalArgumentException("Invalid input");
		this.dice = new int[numDice];
		this.random = new Random(new Date().hashCode());		//Sets seed value
		roll();
	}

	private int rollDie() {		//Rolls a die (1-6)
		return random.nextInt(6) + 1;
	}

	public int roll() {		//Finds sum of all rolls
		int sum = 0;
		for (int i = 0; i < dice.length; i++) {
			dice[i] = rollDie();
			sum += dice[i];
		}
		return sum;
	}

	public int[] getDieValues() {		//Creates defensive clone
		return dice.clone();
	}

	public boolean hasDoubles() {		//Checks if any of the values in the array occurs more than once
		Set<int[]> mySet = Set.of(dice);
		if (mySet.size() == dice.length) {
			return false;
		}
		return true;
	}

	public String toString() {		//Converts array to string
		String numVals = "";
		for (int i = 0; i < dice.length; i++) {
			numVals += dice[i] + " ";
		}

		return numVals;
	}
}

