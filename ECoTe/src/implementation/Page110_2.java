package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page110_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = 0;
		int y = 0;
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			if(str.equals("L")) {
				int ny = y-1;
				if(ny<=-1) continue;
				else {
					y = ny;
				}
			} else if(str.equals("R")) {
				int ny = y+1;
				if(ny>=n) continue;
				else {
					y = ny;
				}
			} else if(str.equals("U")) {
				int nx = x-1;
				if(nx<=-1) continue;
				else {
					x = nx;
				}
			} else if(str.equals("D")) {
				int nx = x+1;
				if(nx>=n) continue;
				else {
					x = nx;
				}
			}
		}
		
		System.out.println((x+1) + " " + (y+1));
	}

}
