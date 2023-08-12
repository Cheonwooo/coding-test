package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EX16926 {
	public static int n, m, r;
	public static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(r!=0) {
			r--;
			for(int i=0; i<Math.min(n, m)/2; i++) {
				turn(i, i);
			}			
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j] + " " );
			}
			System.out.println();
		}
	}
	
	public static void turn(int x, int y) {
		int temp = map[x][y];
		for(int i=y; i<m-1-y; i++) {
			map[x][i] = map[x][i+1];
		}
		for(int i=x; i<n-1-x; i++) {
			map[i][m-1-y] = map[i+1][m-1-y];
		}
		for(int i=m-1-y; i>y; i--) {
			map[n-1-x][i] = map[n-1-x][i-1];
		}
		for(int i=n-1-x; i>x; i--) {
			map[i][y] = map[i-1][y];
		}
		map[x+1][y] = temp;
	}

}
