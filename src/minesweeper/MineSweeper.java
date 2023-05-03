package minesweeper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

/**
 * MineSweeper is class which is used to create the event loop
 * in the main method it has board numberOfclick, level, numMines
 * score, topscorer, as its instance variables.
 * it has following methods 
 * 01. String printBoard();
 * 02. String revelMine();
 * 03. void makeFirstClick(int row,int col);
 * 04. String makeClick(int row, int col);
 * 05. void checkNeighbour(int row, int col);
 * 06. void showNeighbourOfZero();
 * 07. void mineGenerator();
 * 08. String makeFlagged(int row, int col, boolean f);
 * 09. setNumberToNeuighbouringMines(Board board);
 * 10. Board getBoardd();
 * 11. boolean win();
 * @author AYUSH
 *
 */
public class MineSweeper {

	private Board board;
	private int numberOfClick =0;
	private Level level;
	private int numMines ;
	private Score score;
    private TopScorer ts;

	/**
	 * Constructor which initializes our game board
	 * @param lev game level
	 * @param name name of the player playing the game
	 */
	public MineSweeper(Level lev,String name){
		this.level = lev;
		this.numMines = level.getNumberOfBombs();
		this.board = new Board(lev);
		this.score = new Score(lev);
		this.ts = new TopScorer(name);

	}

	/**
	 * stores the game board i.e user interface in the string used to 
	 * display it in event loop
	 * 
	 * @return String format of the game board
	 */
	public String PrintBoard() {
		String s = "----------------------GAME-BOARD---------------------\n";
		for (int i = 0; i < this.level.getRows(); i++) {
			s = s + "-----------------------------------------------------\n";
			for (int j = 0; j < this.level.getCols(); j++) {
				if(this.board.getBoard().get(i).get(j).isClicked()){

					s = s+" "+board.getBoard().get(i).get(j).getNumNeighbors()+" " + " | ";

				}else if(this.board.getBoard().get(i).get(j).isFlagged()){

					s= s+"#"+"#"+"#"+" | ";

				}
				else {

					s= s+i+","+j+" | ";
				}

			}
			s = s+"\n";

		}s = s + "-----------------------------------------------------\n";
		s=s+"----------------------GAME-BOARD---------------------\n";
		return s;
	}

	/**
	 * it revels the position of all the bombs placed
	 * @return string which is used to display in event loop
	 */
	public String revealMine(){
		score.updateRevelAns();
		String m ="------------------------BOMBS------------------------\n";
		
		for(int i=0;i<board.getBoard().size();i++){
			m = m + "-----------------------------------------------------\n";
			for(int j =0; j<board.getBoard().get(i).size();j++){
				if(!board.getBoard().get(i).get(j).isMine()){
					if(board.getBoard().get(i).get(j).getNumNeighbors()!=-1){
						m = m+" "+board.getBoard().get(i).get(j).getNumNeighbors()+" " + " | ";
						continue;
					}
					m=m+i+","+j+" | ";

				}else{
					m=m+" *  | ";
				}		
			}//System.out.print("|");
			m = m+"\n";
		}m = m + "-----------------------------------------------------\n";
		m = m+"------------------------BOMBS------------------------\n";
		return m;
	}

	/**
	 * used to make a first click while playing the game
	 * it takes row value and column values as input 
	 * and makes the click
	 * @param row row value of the board to make click
	 * @param col column value of the board to make click
	 */
	private void makeFirstClick(int row,int col){
		
		if(numberOfClick==0){
			this.score.updateRevealedCells();
			this.board.getBoard().get(row).get(col).setClicked(true);
			//			board.getBoard().get(row).get(col).setNumNeighbors(3);
			this.numberOfClick +=1;
			this.mineGenerator();
			this.setNumberToNeuighbouringMines(board);
		}
	}

	/**
	 * used in event loops for making clicks
	 * @param row value to click
	 * @param col value to click
	 * @return string representation of board after 
	 * the game is finished revels mines
	 */
	public String makeClick(int row, int col){
		this.makeFirstClick(row, col);
		if(this.board.getBoard().get(row).get(col).isMine()){
//			System.out.println();
//			System.out.println();
//			System.out.println();
			this.ts.setScore(score.getScore());
			try {
				this.ts.writeFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				this.ts.readFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "----------------------game over----------------------\n"
					+"\n"+this.revealMine();
		}else if (this.board.getBoard().get(row).get(col).getNumNeighbors()>0){
			this.board.getBoard().get(row).get(col).setClicked(true);
			this.score.updateRevealedCells();
			this.numberOfClick+=1;
			return "";
			
		}else if(this.board.getBoard().get(row).get(col).getNumNeighbors()==0){
			this.checkNeighbour(row, col);
			this.showNeighbourOfZero();
			this.numberOfClick+=1;
			return "";
		}
		return "";

	}
	
	/**
	 * on making a click it recursively revels all the neighbor
	 * positions which are zero
	 * @param row on which click was made
	 * @param col on which click was made
	 */
	public  void checkNeighbour(int row, int col){
		for(int i =-1;i<=1;i++){

			for(int j= -1; j<=1;j++){
				if (row+i >= 0 && row+i < this.board.getBoard().size() && 
						col+j >= 0 && col+j < this.board.getBoard().get(row).size()
						&& this.board.getBoard().get(row+i).get(col+j).getNumNeighbors()==0
						&& !this.board.getBoard().get(row+i).get(col+j).isFlagged()
						&& !this.board.getBoard().get(row+i).get(col+j).isClicked()) 
				{
					this.board.getBoard().get(row+i).get(col+j).setClicked(true);
					this.score.updateRevealedCells();
					checkNeighbour(row+i,col+j);
				}
			}
		}
	}
	
	/**
	 * this function reveals all the positions which are neighbor of zero
	 */
	public void showNeighbourOfZero(){
		for (int x = 0; x < this.board.getBoard().size(); x++)
		{
			for (int y = 0; y < this.board.getBoard().get(x).size(); y++) 
			{
				for (int i = -1; i <= 1; i++) 
				{
					for (int j = -1; j <= 1; j++) 
					{
						if(this.board.getBoard().get(x).get(y).getNumNeighbors()==0&&
								this.board.getBoard().get(x).get(y).isClicked()){
						if(x+i >= 0 && x+i < board.getBoard().get(x).size()
								&& y+j >= 0 && y+j < board.getBoard().get(x).size()
								&& !this.board.getBoard().get(x+i).get(y+j).isFlagged()
								&& !this.board.getBoard().get(x+i).get(y+j).isClicked()) 
						{
							this.board.getBoard().get(x+i).get(y+j).setClicked(true);
							this.score.updateRevealedCells();
						}
						}
					}
				}
			}
		}
	}
	
	/**
	 * its an utility method used in make click method
	 * after first click it randomly generates the bombs 
	 * based on the difficulty level
	 */
	private void mineGenerator(){
		Random rand = new Random();
		for (int i = 0; i < numMines; i++) {
			int x = rand.nextInt(this.level.getRows());
			int y = rand.nextInt(this.level.getCols());
			if (!board.getBoard().get(x).get(y).isMine()&& !board.getBoard().get(x).get(y).isClicked()) {
				board.getBoard().get(x).get(y).setMine(true);
			} else {
				i--; 
			}
		}
	}

	/**
	 * used to mark the mine flagged or not flagged;
	 * @param row row value of the board to make it as flagged
	 * @param col column value of the board to make it as flagged
	 * @param f sets flags as true or false
	 * @return String describing about the flag set or not
	 */
	public String makeFlagged(int row, int col, boolean f) {

		if(this.numberOfClick>0){
			if(!this.board.getBoard().get(row).get(col).isClicked())
			{
				this.board.getBoard().get(row).get(col).setFlagged(f);
				if(this.board.getBoard().get(row).get(col).isFlagged()
						&& this.board.getBoard().get(row).get(col).isMine())
				{
					this.score.updateFlaggedMines();
				}
				else if(this.board.getBoard().get(row).get(col).isFlagged()
						&& !this.board.getBoard().get(row).get(col).isMine())
				{
					this.score.updateIncorrectFlags();
				}
				return "set to falagged";
			}
		}
		return "cannot set to falgged";
	}

	/**
	 * this methods calculates the numbers of each of the box
	 * and set the value of Cell numNegighnours based on the
	 * calculation
	 * @param board takes board instance and set number to cells 
	 * based on the neighboring mines
	 */
	private void setNumberToNeuighbouringMines(Board board){
		for (int x = 0; x < board.getBoard().size(); x++)
		{
            for (int y = 0; y < board.getBoard().get(x).size(); y++) 
            {
                int numNeighbors = 0;
                for (int i = -1; i <= 1; i++) 
                {
                    for (int j = -1; j <= 1; j++) 
                    {
                        if (x+i >= 0 && x+i < board.getBoard().get(x).size() && 
                        		y+j >= 0 && y+j < board.getBoard().get(x).size()
                        		&& board.getBoard().get(x+i).get(y+j).isMine()) 
                        {
                            numNeighbors++;
                        }
                    }
                }
                board.getBoard().get(x).get(y).setNumNeighbors(numNeighbors);
            }
        }
    }

	/**
	 * getter method for board;
	 * @return board instance
	 */
	public Board getBoardd() {
		// TODO Auto-generated method stub
		return this.board;
	}
	
	/**
	 * if count is equals to total number of cells then gave is finished
	 * @return true or false based on the cells data
	 */
	public boolean win(){
		int count =0;
		for (int x = 0; x < this.board.getBoard().size(); x++)
		{
			for (int y = 0; y < this.board.getBoard().get(x).size(); y++) 
			{
				if(this.board.getBoard().get(x).get(y).isClicked()
						|| this.board.getBoard().get(x).get(y).isFlagged())
				{
					count++;
				}
			}
		}
		if(this.level.getCols()*this.level.getRows()==count){
			try {
				this.ts.writeFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				this.ts.readFile();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

}
