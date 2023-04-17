package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Page152 {
	public static int n, m;
	public static int[][] arr;
	public static Queue<Pair> q= new LinkedList<>();
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			for(int j=m; j>0; j--) {
				arr[i][m-j] = num/(int)(Math.pow(10, j-1));
				num %= (int)(Math.pow(10, j-1));
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(bfs(0,0));
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
		q.add(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			x = cur.x;
			y = cur.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=m) {
					continue;
				}
				if(arr[nx][ny]==0) {
					continue;
				}
				if(arr[nx][ny]==1) {
					arr[nx][ny] = arr[x][y]+1;
					q.add(new Pair(nx, ny));
				}
			}
		}
		
		return arr[n-1][m-1];
	
	}
}
