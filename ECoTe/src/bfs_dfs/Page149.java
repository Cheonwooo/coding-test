package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page149 {
	public static int n, m, cnt;
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[1000][1000];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		cnt = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dfs(i, j)) cnt++;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(cnt);
	}
	
	public static boolean dfs(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=m) {
			return false;
		}
		
		if(arr[x][y]==0) {
			arr[x][y]=cnt;
			
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			
			return true;
		}
		return false;
	}

}
