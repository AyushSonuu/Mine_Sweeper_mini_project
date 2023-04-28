package minesweeper;

import java.util.Random;

/**
 * MineSweeper is class which is used to create the event loop
 * in the main method it has board numberOfclick, level and numMines
 * as its instance variables
 * @author AYUSH
 *
 */
public class MineSweeper {
	
	private Board board;
	private int numberOfClick =0;
	private Level level;
	private int numMines ;
	
	/**
	 * Constructor which initializes our game board
	 * @param easy2 of the game decided by the user
	 */
	public MineSweeper(Level lev){
		this.level = lev;
		this.numMines = level.getNumberOfBombs();
		this.board = new Board(lev);
		
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
					
					s = s+" "+board.getBoard().get(i).get(j)+" " + " | ";
					
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
		String m ="------------------------BOMBS------------------------\n";

		for(int i=0;i<board.getBoard().size();i++){
			m = m + "-----------------------------------------------------\n";
			for(int j =0; j<board.getBoard().get(i).size();j++){
				if(!board.getBoard().get(i).get(j).isMine()){
					if(board.getBoard().get(i).get(j).getNumNeighbors()!=-1){
						m = m+" "+board.getBoard().get(i).get(j)+" " + " | ";
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
	 * @param row
	 * @param col
	 */
	private void makeFirstClick(int row,int col){
		if(numberOfClick==0){
			this.board.getBoard().get(row).get(col).setClicked(true);
//			board.getBoard().get(row).get(col).setNumNeighbors(3);
			this.numberOfClick +=1;
			this.mineGenerator();
			UtilityMineSweeper.setNumberOfNeuighbouringMines(board);
		}
	}
	
	/**
	 * used in event loops for making clicks
	 * @param row value to click
	 * @param col value to click
	 */
	public void makeClick(int row, int col){
		this.makeFirstClick(row, col);
		if(this.board.getBoard().get(row).get(col).isMine()){
			System.out.println("game over");
			System.out.println(this.revealMine());
		}else{
			this.board.getBoard().get(row).get(col).setClicked(true);
			this.numberOfClick+=1;
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
	 * @param row
	 * @param col
	 * @return String describing about the falg set or not
	 */
	public String makeFlagged(int row, int col, boolean f) {
		
		if(this.numberOfClick>0){
			if(!this.board.getBoard().get(row).get(col).isClicked())
			{
				this.board.getBoard().get(row).get(col).setFlagged(f);
				return "set to falagged";
			}
				}
		return "cannot set to falgged";
		}
		

}
