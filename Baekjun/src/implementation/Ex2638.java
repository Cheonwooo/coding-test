package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2638 {
	
	public static int n, m;
	public static int[][] map, temp;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		temp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		int cnt = 0;
		while(true) {
			cnt++;
			dfs(0, 0);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]==1) {
						cheeze(i, j);
					}
				}
			}
			if(check()) break;
			copy();
		}
		System.out.println(cnt);
		
	}
	public static boolean check() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j]==1) return false;
			}
		}
		return true;
	}
	
	public static void copy() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	public static void cheeze(int x, int y) {
		
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) continue;
			if(map[nx][ny]==2) cnt++;
		}
		if(cnt>=2) {
			temp[x][y] = 0;
		}
	}
	
	public static boolean dfs(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=m) {
			return false;
		}
		
		if(map[x][y]==0) {
			map[x][y] = 2;
			
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			
			return true;
		}
		return false;
	}

}
