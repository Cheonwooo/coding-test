package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2178 {
	public static int n,m;
	public static int[][] arr;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static Queue<Pair> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = (int)(str.charAt(j)-'0');
			}
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
				int now_x = x+dx[i];
				int now_y = y+dy[i];
				
				if(now_x<0 || now_x>=n || now_y<0 || now_y>=m) {
					continue;
				}
				if(arr[now_x][now_y]==0) {
					continue;
				}
				if(arr[now_x][now_y]==1) {
					arr[now_x][now_y] = arr[x][y]+1;
					q.add(new Pair(now_x, now_y));
				}
			}
		}
		return arr[n-1][m-1];
			
	}
}
