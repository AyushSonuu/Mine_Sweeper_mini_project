package minesweeper;

/**
 * decides the level of the game 
 * @author VISHAL BIRADER
 *
 */
public final class Level {
	
	private int rows;
	private int cols;
	private int numberOfBombs;
	public static final  Level EASY = new Level(9, 9, 10);
	public static final  Level INTERMEDIATE = new Level(16, 16, 40);
	public static final  Level EXPERT = new Level(16,30, 99);
	
	/**
	 * constructor creates used to set level
	 * @param rows number of rows in the board
	 * @param cols number of columns in the board
	 * @param numberOfBombs total number of mines in the board
	 */
	private Level(int rows, int cols, int numberOfBombs) {
		this.rows = rows;
		this.cols = cols;
		this.numberOfBombs = numberOfBombs;
	}
	
	/**
	 * used fetch number of rows of board
	 * @return returns number of rows
	 */
	public int getRows() {
		return rows;
	}
	
	/**
	 * used fetch number of columns of board
	 * @return returns columns of the board according to level
	 */
	public int getCols() {
		return cols;
	}
	
	/**
	 * used fetch number of rows of number of boards
	 * @return number of bombs
	 */
	public int getNumberOfBombs() {
		return numberOfBombs;
	}
 
}
