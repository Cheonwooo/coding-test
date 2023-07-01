package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16 {
	public static int n, m;
	public static int[][] map, temp;
	public static boolean[][] visited;
	public static int max = Integer.MIN_VALUE;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		temp = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0);
		
		System.out.println(max);
	}
	
	public static void bfs(int count) {
		if(count==3) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					temp[i][j] = map[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(temp[i][j]==2) {
						virus(i, j);
					}
				}
			}
				
			max = Math.max(max, check());
			return;
			
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					map[i][j] = 1;
					count+=1;
					bfs(count);
					map[i][j] = 0;
					count -= 1;
					
				}
			}
		}
	}
	public static void virus(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<=-1 || nx>=n || ny<=-1 || ny>=m) {
				continue;
			}
			if(temp[nx][ny]==0) {
				temp[nx][ny]=2;
				
				virus(nx, ny);
			}
		}
	}
	
	public static int check() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
