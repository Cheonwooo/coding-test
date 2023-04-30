package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1926 {
	public static int n, m;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int max = Integer.MIN_VALUE;
	public static Queue<Pair> q = new LinkedList<>();
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

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
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j] && arr[i][j]==1) {//방문하지 않았고, 1이라면
					visited[i][j] = true;
					max = Math.max(max, bfs(i, j));
					cnt++;
					
				}
			}
		}
		
		System.out.println(cnt);
		if(cnt==0) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}

	}
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int bfs(int x, int y) {
		int sum = 1;
		q.add(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			x = cur.x;
			y = cur.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <= -1 || nx >= n || ny <= -1 || ny >= m) {
					continue;
				}
				if(arr[nx][ny] == 0) {
					continue;
				}
				if(arr[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					sum += 1;
					
					q.add(new Pair(nx, ny));
				}
			}
		}
		return sum;
	}
}
