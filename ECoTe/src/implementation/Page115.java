package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Page115 {

	public static void main(String[] args)	throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String[] arr_str = {"a", "b", "c", "d", "e", "f", "g", "h"};
		int[] arr_int = {1, 2, 3, 4, 5, 6, 7, 8};
		int[][] move = {{-1,-2}, {1,-2}, {-2,-1}, {-2,1}, {-1,2}, {1,2}, {2,-1}, {2,1}};
		
		int y = 0;
		for(int i=0; i<arr_str.length; i++) {
			if(String.valueOf(str.charAt(0)).equals(arr_str[i])) {
				y = arr_int[i];
			}
		}
		int x = Integer.parseInt(String.valueOf(str.charAt(1)));
		
		int cnt = 0;
		for(int i=0; i<move.length; i++) {
			int nx = x + move[i][0];
			int ny = y + move[i][1];
			
			if(nx<1 || nx>8 || ny<1 || ny>8) {
				continue;
			} 
			cnt++;
		}
		System.out.println(cnt);
	}

}
