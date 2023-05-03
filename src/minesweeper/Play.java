package minesweeper;

import java.util.Scanner;

public class Play {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		game();
}
	
	/**
	 * starting and playing the game
	 */
	public static void game(){
	System.out.println("----------ENTER YOUR SWEET NAME----------");
	String name = sc.nextLine();
	MineSweeper m1 = new MineSweeper(Level.EASY,name);
	//event loop
	while(true){
		
		System.out.println(m1.PrintBoard());
		System.out.println("enter the position as a string eg 4,4 is 44\n"
				+ "1.click on the position \n"
				+ "2.mark as falgged\n"
				+ "3.mark as unflagged\n"
				+ "4.revel the Bombs\n"
				+ "5.restart the game\n"
				+ "6.exit");

		int swca = sc.nextInt();
		if(m1.win())System.out.println("CONGRACTULATIONS YOU WON THE MATCH");
		if(swca==6)break;
		else if(swca == 1){
				System.out.println("Enter the position to click");
				String position = sc.next();
				int row = Integer.parseInt(position.substring(0, 1));
				System.out.println(row);
				int col= Integer.parseInt(position.substring(1, 2));
				System.out.println(col);
				System.out.println(m1.makeClick(row, col));
				if(m1.getBoardd().getBoard().get(row).get(col).isMine())
					break;
				
				
		}
		switch(swca)
		{
		case 2:
		{
			System.out.println("enter position to make it as flagged");
			String position = sc.next();
			int row = Integer.parseInt(position.substring(0, 1));
			System.out.println(row);
			int col= Integer.parseInt(position.substring(1, 2));
			System.out.println(col);
			m1.makeFlagged(row,col,true);
			break;

		}
		case 3:
		{
			System.out.println("enter position to make it as Unflagged");
			String position = sc.next();
			int row = Integer.parseInt(position.substring(0, 1));
			System.out.println(row);
			int col= Integer.parseInt(position.substring(1, 2));
			System.out.println(col);
			m1.makeFlagged(row,col,false);
			break;

		}
		case 4:
		{
			System.out.println(m1.revealMine());
			break;

		}
		case 5 :
		{
			game();
		}
		default :
		{
			System.out.println("enter a valid choice");
		}
		}
	}
	sc.close();
}
}

