package minesweeper;

import java.util.ArrayList;

/**
 * it creates a 2D array of Cell type
 * which is our board
 * @author MRUDULA PATIL
 *
 */
public class Board {
	private ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();
	
	/**
	 * constructor takes level as input
	 * @param lev it takes input as level of the game
	 */
	public Board(Level lev){
		if (lev==Level.EASY){
			board = initilizeArray(board,Level.EASY.getRows(), Level.EASY.getCols());
		}else if(lev == Level.INTERMEDIATE){
			board = initilizeArray(board,Level.INTERMEDIATE.getRows(), Level.INTERMEDIATE.getCols());
		}else if(lev==Level.EXPERT){
			board = initilizeArray(board,Level.EXPERT.getRows(),Level.EXPERT.getCols());
		}
	}

	/**
	 * returns board instance
	 * @return returns the board instance
	 */
	public ArrayList<ArrayList<Cell>> getBoard() {
		return board;
	}

	/**
	 * creates cell instance for every position and assigns 
	 * with default values
	 * @param arr 2D ArayList 
	 * @param roww number of rows based on difficulty
	 * @param coll number of columns based on difficulty
	 * @return 2D ArrayList of Objects of Cell class
	 */
	public ArrayList<ArrayList<Cell>> initilizeArray(ArrayList<ArrayList<Cell>> arr,int roww, int coll){
		for (int i = 0; i <roww ; i++) {
			ArrayList<Cell> row = new ArrayList<Cell>();
			for (int j = 0; j < coll; j++) {
				Cell c = new Cell();
				row.add(c); // Add the element to the row
			}
			arr.add(row); // Add the row to the matrix
		}return arr;
	}
}
