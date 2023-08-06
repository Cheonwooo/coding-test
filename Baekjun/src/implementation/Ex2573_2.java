package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2573_2 {
	public static int n, m;
	public static int[][] map, temp;
	public static boolean[][] visited;
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
				temp[i][j] = map[i][j];
			}
		}
		
		
		int year = 0;
		while(true) {
			year++;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(map[i][j]!=0) {
						bfs(i, j);
					}
				}
			}
			
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(temp[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			copy(map, temp);
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(dfs(i, j)) cnt++;
				}
			}
			if(cnt>=2) break;
			else {
				copy(temp, map);
				cnt=0;
				
				boolean check = true;
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						if(map[i][j]!=0) check = false;
					}
				}
				if(check) {
					year = 0;
					break;
				}
			}
			
		}
		System.out.println(year);
	}
	public static void copy(int[][] arr1, int[][] arr2) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr1[i][j] = arr2[i][j];
			}
		}
	}
	
	public static void bfs(int x, int y) {
		//동서남북 확인 했을 때 0의 개수
		int del = 0;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<m &&map[nx][ny]==0) del++;
		}
		
		temp[x][y] -= del;
		if(temp[x][y]<0) temp[x][y] = 0;
	}
	
	public static boolean dfs(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=m) {
			return false;
		}
		
		if(temp[x][y]!=0) {
			temp[x][y]=0;
			
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			
			return true;
		}
		return false;
	}

}
