package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14502_2 {
	public static int n, m;
	public static int max = Integer.MIN_VALUE;
	public static int[][] map, new_map;
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		new_map = new int[n][m];
		boolean[][] check =new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				new_map[i][j] = map[i][j];
			}
		}
		virus(0);
		
		System.out.println(max);
	}
	
	public static void virus(int r){
		if(r==3) {//3개를 다 세웠다면
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					new_map[i][j] = map[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(new_map[i][j]==2) {
						dfs(i,j);
					}
				}
			}
			
			max = Math.max(max, check());
			return;
			
		}
		
		for(int i=0; i<n; i++) {//벽세우기
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					r+=1;
					virus(r);
					map[i][j]=0;
					r-=1;
				}
			}
		}
		
		
	}
	
	public static void dfs(int x, int y) { //바이러스 전파
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<=-1 || nx>=n || ny<=-1 || ny>=m) {
				continue;
			} 
			if(new_map[nx][ny]==0) {
				new_map[nx][ny]=2;
				dfs(nx, ny);
			}
		}
		
		
	}
	
	public static int check() {
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(new_map[i][j]==0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}

}
