package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Page115_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		
		int x = (str[0].charAt(0)-'a');
		int y = Integer.parseInt(str[1]);		
		
		int[][] move = {{-2,-1}, {-1, -2}, {1,-2}, {2,-1}, {2,1}, {1,2}, {-1,2}, {-2,1}};
		
		int cnt = 0;
		for(int i=0; i<move.length; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			
			if(nx<=0 || nx>=9 || ny<=0 || ny>=9) {
				continue;
			} 
			
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
