package minesweeper;

import java.util.ArrayList;
/**
 * 
 * @author MRUDULA PATIL
 *
 */
public class Board {
	private ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();

	public Board(Level lev){
		if (lev==Level.EASY){
			board = initilizeArray(board,Level.EASY.getRows(), Level.EASY.getCols());
		}else if(lev == Level.INTERMEDIATE){
			board = initilizeArray(board,Level.INTERMEDIATE.getRows(), Level.INTERMEDIATE.getCols());
		}else if(lev==Level.EXPERT){
			board = initilizeArray(board,Level.EXPERT.getRows(),Level.EXPERT.getCols());
		}
	}

	public ArrayList<ArrayList<Cell>> getBoard() {
		return board;
	}

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
