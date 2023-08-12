package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14890 {
	public static int n, l;
	public static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(checkRow(i)) {
				cnt++;
			}
			
			if(checkCol(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean checkRow(int row) {
		boolean[] visited = new boolean[n]; 
		for(int i=0; i<n-1; i++) {
			int dif = map[row][i] - map[row][i+1];
			
			if(dif==0) continue;
			if((int)Math.abs(dif)>1) return false;
			if(dif==1) {//내려가는 경우
				for(int j=i+1; j<=i+l; j++) {
					if(j>=n || map[row][i+1] != map[row][j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			} else if(dif==-1) {
				for(int j=i; j>i-l; j--) {
					if(j<0 || map[row][i] != map[row][j] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			}
		}
		return true;
	}
	
	public static boolean checkCol(int col) {
		boolean[] visited = new boolean[n];
		for(int i=0; i<n-1; i++) {
			int dif = map[i][col] - map[i+1][col];
			
			if(dif==0) continue;
			if(Math.abs(dif)>1) return false;
			if(dif==1) {
				for(int j=i+1; j<=i+l; j++) {
					if(j>=n || map[i+1][col] != map[j][col] || visited[j]) {
						return false;
					}
					visited[j] = true;
				}
			} else if(dif==-1) {
				for(int j=i; j>i-l; j--) {
					if(j<0 || map[i][col] != map[j][col] || visited[j]) {
						return false;
					}
					visited[j] = true; 
				}
			}
		}
		return true;
	}
}
