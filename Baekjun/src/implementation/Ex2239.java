package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2239 {
	public static int[][] arr;
	public static boolean end = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9][9];
		for(int i=0; i<9; i++) {
			String[] str = br.readLine().split("");
			
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		dfs(0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int n) {
		if(n==81) {
			end = true;
			return;
		}
		
		int x = n/9;
		int y = n%9;
		
		if(arr[x][y] != 0) {
			dfs(n+1);
		} else {
			for(int i=1; i<=9; i++) {
				if(!check(x, y, i)) continue;
				arr[x][y] = i;
				dfs(n+1);
				if(end) return;
				arr[x][y] = 0;
			}
		}
	}
	
	public static boolean check(int x, int y, int n) {
		for(int i=0; i<9; i++) {
			if(arr[x][i] == n || arr[i][y] == n) return false;
		}
		
		int nx = x/3*3;
		int ny = y/3*3;
		
		for(int i=nx; i<nx+3; i++) {
			for(int j=ny; j<ny+3; j++) {
				if(arr[i][j] == n) return false;
			}
		}
		return true;
	}
}
