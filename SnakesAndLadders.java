package SnL;

/**
 * Program simulates a game of Snakes and Ladders
 * 
 * @author Kush Gopeechund
 *
 */

public class SnakesAndLadders {
	public static final int NUM_PLAYERS = 2;
	public static final int NUM_SQUARES = 100;
	private SnLSquare[] board;
	private int[] players;
	private Dice dice;

	/**
	 * Default constructor set as 2 players
	 */
	public SnakesAndLadders() {
		this(2);
	}

	/**
	 * Constructor named SnakesAndLadders sets the board with snake locations and
	 * ladder locations by using SnLSquare(), LadderSquare() and SnakeSquare().
	 * 
	 * @param nPlayers
	 */
	public SnakesAndLadders(int nPlayers) {
		players = new int[NUM_PLAYERS];
		dice = new Dice();
		board = new SnLSquare[NUM_SQUARES];

		for (int i = 0; i < NUM_SQUARES; i++) {
			board[i] = new SnLSquare(i + 1);
		}

		board[3] = new LadderSquare(4, 14);
		board[8] = new LadderSquare(9, 31);
		board[19] = new LadderSquare(20, 38);
		board[39] = new LadderSquare(40, 59);
		board[27] = new LadderSquare(28, 84);
		board[62] = new LadderSquare(63, 81);
		board[70] = new LadderSquare(71, 91);

		board[16] = new SnakeSquare(17, 7);
		board[53] = new SnakeSquare(54, 34);
		board[61] = new SnakeSquare(62, 18);
		board[63] = new SnakeSquare(64, 60);
		board[86] = new SnakeSquare(87, 24);
		board[92] = new SnakeSquare(93, 73);
		board[94] = new SnakeSquare(95, 75);
		board[98] = new SnakeSquare(99, 78);

		for (int i = 0; i < NUM_PLAYERS; i++) {
			players[i] = 1;
		}

	}

	/**
	 * Simulates a player taking a turn. Rolls a set of dice and returns true if a
	 * double number is rolled, returns false if different numbers are rolled.
	 * 
	 * @param player
	 * @return a boolean whether the player plays again
	 */
	public boolean takeTurn(int player) {
		players[player] += dice.roll();
		if (players[player] > NUM_SQUARES) {
			players[player] = 200 - players[player];
		}
		System.out.println("Player " + (player + 1) + " rolled " + (dice.getDieValues()[0] + dice.getDieValues()[1]));
		players[player] = board[players[player] - 1].landOn();
		if (dice.getDieValues()[1] == dice.getDieValues()[0]) {		//Used this method instead of hasDoubles() because it wasn't working
			System.out.println("Rolled a double");
			System.out.println(toStringCurrentPositions());
			return true;
		} else {
			System.out.println(toStringCurrentPositions());
			return false;
		}
	}

	/**
	 * Returns true is a player is on the 100th square, returns false if not.
	 * 
	 * @param player
	 * @return a boolean whether there is a winner
	 */
	public boolean isPlayerWinner(int player) {
		if (getPlayerPosition(player) == 100) {
			return true;
		}
		return false;
	}

	/**
	 * Checks which player is on the 100th square and returns that player by calling
	 * getPlayerPosition. Returns -1 if there isn't a player on the 100th square.
	 * 
	 * @return an integer of the player who won
	 */
	public int getWinner() {
		for (int i = 0; i < NUM_PLAYERS; i++) {
			if (getPlayerPosition(i) == 100) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Returns a players position.
	 * 
	 * @param player
	 * @return an integer of the players position
	 */
	public int getPlayerPosition(int player) {
		return players[player];
	}

	/**
	 * Creates and returns the game board.
	 * 
	 * @return a string of the game board.
	 */
	public String toString() {
		String gameBoard = "";
		for (int i = 0; i < 100;) {
			for (int j = 0; j < 10; j++) {
				gameBoard += "| " + board[i] + " ";
				i++;
			}
			gameBoard += "\n";
		}
		return gameBoard;
	}

	/**
	 * Returns the player and the players position by calling getPlayerPosition().
	 * 
	 * @return a string of the position of the player
	 */
	public String toStringCurrentPositions() {
		String playPos = "";
		for (int i = 0; i < NUM_PLAYERS; i++) {
			playPos += (i + 1) + ":" + getPlayerPosition(i) + " ";
		}
		return playPos;
	}

	/**
	 * Prints out the title of the game and the game board. It then runs through the
	 * players turn by calling takeTurn(), until a winner is found. When a winner is
	 * found, it prints out the player that won.
	 * 
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		SnakesAndLadders SNL = new SnakesAndLadders();
		System.out.println("Snakes and Ladders");
		System.out.println(SNL.toString() + "\n");
		while (SNL.getWinner() == -1) {
			for (int i = 0; i < NUM_PLAYERS; i++) {
				while (SNL.takeTurn(i)) {
				}
				if (SNL.getWinner() != -1) {
					break;
				}
			}
		}
		System.out.println("Player " + (SNL.getWinner() + 1) + " wins.");
	}
}
