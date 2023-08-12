package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2636 {
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
		
		int answer = check();
		int cnt = 0;
		
		while(true) {
			cnt++;
			dfs(0, 0);
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<m-1; j++) {
					if(map[i][j]==1) {
						cheeze(i, j);
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					map[i][j] = temp[i][j];
				}
			}			
			if(check()==0) {
				break;
			} else {
				answer = check();
			}
		}
		System.out.println(cnt);
		System.out.println(answer);

	}
	
	public static boolean dfs(int x, int y) {
		if(x<0 || x>=n || y<0 || y>=m) {
			return false;
		}
		if(map[x][y]==0) {
			map[x][y]=2;
			
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			
			return true;
		}
		return false;
	}
	
	public static void cheeze(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]==2) {
				temp[x][y]=0;
				break;
			}
		}
	}
	
	public static int check() {
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==1) cnt++;
			}
		}
		
		return cnt;
	}
	
}
