package minesweeper;


public class UtilityMineSweeper {
	/**
	 * this methods calculates the numbers of each of the box
	 * and set the value of Cell numNegighnours based on the
	 * calculation
	 * @return void
	 */
	public static void setNumberOfNeuighbouringMines(Board board){
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

	
}


