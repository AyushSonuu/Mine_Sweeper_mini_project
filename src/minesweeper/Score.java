package minesweeper;

/**
 * calculates the score based 
 * on difficulty level and mines
 * @author AYUSH
 *
 */
public class Score {
    private Level difficulty;
    private int revealedCells;
    private int flaggedMines;
    private int incorrectFlags;
    private int revelAns;

    /**
     * constructor which takes as difficulty
     * level as argument
     * @param difficulty Level of the game
     */
    public Score(Level difficulty) {
        this.difficulty = difficulty;
        this.revealedCells = 0;
        this.flaggedMines = 0;
        this.incorrectFlags = 0;
    }
    
    /**
     * increments the reveled cells by +1
     */
    public void updateRevealedCells() {
        this.revealedCells++;
    }
    
    /**
     * updates the revel answer by +1
     */
    public void updateRevelAns() {
        this.revelAns++;
    }
    
    /** 
     * updates the flagged mines count by +1
     */
    public void updateFlaggedMines() {
        this.flaggedMines++;
    }

    /**
     * update incorrect flag count by +1
     */
    public void updateIncorrectFlags() {
        this.incorrectFlags++;
    }
    
    /**
     * calculates the score based on the difficulty level
     * @return calculated score 
     */
    public int getScore() {
        int points = 0;
       if (this.difficulty==Level.EASY){
           points += 10;
       }
       else if(this.difficulty==Level.INTERMEDIATE){
           points += 20;
       }
       else if(this.difficulty==Level.EXPERT){
    	   points += 30;
       }
       else{
                throw new IllegalArgumentException("Invalid difficulty level");
        }
        points *= (this.revealedCells);
        points += (this.flaggedMines * 50);
        points -= (this.incorrectFlags * 20);
        points -= (this.revelAns*10);
        return points;
    }
}
