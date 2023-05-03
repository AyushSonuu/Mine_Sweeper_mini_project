package minesweeper;

/**
 * cell class which is the smallest 
 * unit of our board it contains all
 * the attributes of the cell that it 
 * can contain. 
 * 1. A cell can be clicked
 * 2. A cell has a mine
 * 3. A cell can be flagged
 * 4. A cell contains a number based on
 * neighboring mines
 * 
 * @author SUMALATHA
 *
 */
public class Cell {
	private boolean isMine;
	private boolean isClicked;
	private boolean isFlagged;
	private int numNeighbors;
	
	/**
	 * this constructor sets everything to false by default
	 * and sets number neighbors to -1  
	 */
	public Cell() {
		this.isMine = false;
		this.isClicked = false;
		this.isFlagged = false;
		this.numNeighbors = -1;
	}
	
	/**
	 * tells weather a cell has mine or not
	 * @return true or false
	 */
	public boolean isMine() {
		return isMine;
	}

	/**
	 * sets the cell as it has mine
	 * @param isMine the particular cell has mine or not
	 */
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	/**
	 * tells weather a cell has clicked by user or not
	 * @return true or false
	 */
	public boolean isClicked() {
		return isClicked;
	}

	/**
	 * set the cell to as clicked
	 * @param isClicked this particular cell is clicked or not
	 */
	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	
	/**
	 * tells weather the cell is flagged or not
	 * @return true or false based on cell information
	 */
	public boolean isFlagged() {
		return this.isFlagged;
	}

	/**
	 * set the cell to as flagged
	 * @param isFlagged if user want to make a cell flagged 
	 */
	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}
	
	/**
	 * tells about how many neighbor cells contains bombs
	 * @return integer value
	 */
	public int getNumNeighbors() {
		return numNeighbors;
	}

	/**
	 * sets numberNeighbours to a value based on the number of mines
	 * @param numNeighbors count of mines neighbouring cells has
	 */
	public void setNumNeighbors(int numNeighbors) {
		this.numNeighbors = numNeighbors;
	}

	/**
	 *to string method of this class which just returns number of neighbor mines
	 */
	@Override
	public String toString() {
		return Integer.toString(this.numNeighbors);
	}

}

