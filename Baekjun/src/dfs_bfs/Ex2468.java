package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2468 {
	public static int n;
	public static int[][] arr;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<101; i++) {
			int cnt = 0;
			visited = new boolean[n][n];
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {				
					
					if(dfs(j, k, i)) {
						cnt++;
					}
					max = Math.max(max, cnt);
					
				}
			}
		}
		System.out.println(max);
	}

	public static boolean dfs(int x, int y, int h) {
		if(x<=-1 || x>=n || y<=-1 || y>=n) {
			return false;
		}
		if(arr[x][y]>h && !visited[x][y]) {
			visited[x][y] = true;
			
			dfs(x-1, y, h);
			dfs(x+1, y, h);
			dfs(x, y-1, h);
			dfs(x, y+1, h);
			
			return true;
		}
		return false;
	}
}
