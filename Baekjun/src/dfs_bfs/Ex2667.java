package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex2667 {
	public static int n, sum;
	public static int[][] arr;
	public static boolean[][] visited;
	public static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = (int)(str.charAt(j) - '0');
			}
		}
		
		sum = 0;
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(dfs(i, j)) {
					cnt++;
					list.add(sum);
					sum = 0;
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cnt);
		for(int v : list) {
			System.out.println(v);
		}
		
	}
	
	public static boolean dfs(int x, int y) {
		if(x <= -1 || x >= n || y <= -1 || y >= n) {
			return false;
		}
		
		if(arr[x][y]==1) {
			sum += arr[x][y];
			arr[x][y]=0;
			
			dfs(x-1, y);
			dfs(x, y+1);
			dfs(x+1, y);
			dfs(x, y-1);
			
			return true;
			
		}
		
		return false;
	}

}
