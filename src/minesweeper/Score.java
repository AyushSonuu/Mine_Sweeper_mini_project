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

    public Score(Level difficulty) {
        this.difficulty = difficulty;
        this.revealedCells = 0;
        this.flaggedMines = 0;
        this.incorrectFlags = 0;
    }

    public void updateRevealedCells() {
        this.revealedCells++;
    }
    
    public void updateRevelAns() {
        this.revelAns++;
    }

    public void updateFlaggedMines() {
        this.flaggedMines++;
    }

    public void updateIncorrectFlags() {
        this.incorrectFlags++;
    }

    public int getScore() {
        int points = 0;
       if (this.difficulty==Level.EASY){
           points += 10;
       }
       else if(this.difficulty==Level.INTERMEDIATE){
           points += 20;
       }
       else if(this.difficulty==Level.INTERMEDIATE){
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
