package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14500_2 {
	public static int n, m;
	public static int[][] arr;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static boolean[][] visited;
	public static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				visited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(max);
		
	}
	
	public static void dfs(int x, int y, int sum, int cnt) {
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<=-1 || nx>=n || ny<=-1 || ny>=m) {
				continue;
			}
			if(!visited[nx][ny]) {
				
				if(cnt == 2) {
					visited[nx][ny] = true;
					dfs(x, y, sum+arr[nx][ny], cnt+1);
					visited[nx][ny] = false;
				}
				visited[nx][ny] = true;
				dfs(nx, ny, sum+arr[nx][ny], cnt+1);
				visited[nx][ny] = false;
			}
		}
	}

}
