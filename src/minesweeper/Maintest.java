package minesweeper;

import java.io.IOException;

public class Maintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkNeighbour(2, 2);
		TopScorer t = new TopScorer("Ayush");
		
		try {
			t.writeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void checkNeighbour(int row, int col){
		for(int i =-1;i<=1;i++){
			for(int j= -1; j<=1;j++){
				System.out.print((row+i+" "+(col+j)+", "));
//				System.out.println();
			}System.out.println();
		}
	}
	
	

}

