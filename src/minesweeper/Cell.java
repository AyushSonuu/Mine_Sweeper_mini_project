package minesweeper;

/**
 * 
 * @author SUMALATHA
 *
 */
public class Cell {
	private boolean isMine;
	private boolean isClicked;
	private boolean isFlagged;
	private int numNeighbors;

	public Cell() {
		this.isMine = false;
		this.isClicked = false;
		this.isFlagged = false;
		this.numNeighbors = -1;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public boolean isClicked() {
		return isClicked;
	}

	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}
	
	public boolean isFlagged() {
		return this.isFlagged;
	}

	public void setFlagged(boolean isFlagged) {
		this.isFlagged = isFlagged;
	}
	

	public int getNumNeighbors() {
		return numNeighbors;
	}

	public void setNumNeighbors(int numNeighbors) {
		this.numNeighbors = numNeighbors;
	}

	@Override
	public String toString() {
		return Integer.toString(this.numNeighbors);
	}

}

