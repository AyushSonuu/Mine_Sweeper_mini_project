package minesweeper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class TopScorer {
	private String Player_name;
	private int score;
	private File f = new File("score.txt");
	
	public TopScorer(String name){
		this.Player_name = name;
	}
	public void readFile() throws FileNotFoundException{
		Scanner sc = new Scanner(f);
		Map<Integer, String> dic = new HashMap<>();
		while(sc.hasNextLine()){
			String s = sc.nextLine();
			String[] srr = s.split(" : ");
			dic.put(Integer.parseInt(srr[1]), srr[0]);
		}
//		@SuppressWarnings("unchecked")
		Set<Integer> scoresarr =  dic.keySet();
		ArrayList<Integer> srr = new ArrayList<>(scoresarr);
		Collections.sort(srr);
		Collections.reverse(srr);
		sc.close();
		if(this.score>=srr.get(0)){
			System.out.println("CONGRATS YOU ARE THE TOP SCORER\n"
				+"NAME : "+dic.get(srr.get(0))
				+"\nSCORE : "+srr.get(1)+"\n");
		}else if(this.score<srr.get(0)){
			System.out.println("YOUR SCORE\n"
					+"NAME : "+this.Player_name
					+"\nSCORE : "+this.score+"\n");
			
			System.out.println("HIGHEST SCORE IS SCORED BY \n"
					+"NAME : "+dic.get(srr.get(0))
					+"\nSCORE : "+srr.get(0)+"\n");
		}
		
		
	}
//	public void
	public void writeFile() throws IOException{
		this.f.createNewFile();
		FileWriter fw = new FileWriter(this.f,true);
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println(this.Player_name+" : "+this.score);
		pw.flush();
		pw.close();
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
