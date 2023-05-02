package minesweeper;

import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MineSweeper m1 = new MineSweeper(Level.EASY);
		//event loop
		while(true){
			System.out.println(m1.PrintBoard());
			System.out.println("enter the position as a string eg 4,4 is 44\n"
					+ "1.click on the position \n"
					+ "2.mark as falgged\n"
					+ "3.mark as unflagged\n"
					+ "4.revel the Bombs\n"
					+ "5.exit");

			int swca = sc.nextInt();
			if(swca==5)break;
			switch(swca)
			{
			case 1:
			{
				System.out.println("Enter the position to click");
				String position = sc.next();
				int row = Integer.parseInt(position.substring(0, 1));
				System.out.println(row);
				int col= Integer.parseInt(position.substring(1, 2));
				System.out.println(col);
				System.out.println(m1.makeClick(row, col));
				break;
			}
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
			default :
			{
				System.out.println("enter a valid choice");
			}
			}
		}
		sc.close();
	}

}
