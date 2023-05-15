package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2206 {
	public static int n, m, cnt;
	public static int[][] arr, copy_arr;
	public static Queue<Pair> one = new LinkedList<>();//1의 위치를 기억할 q
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static boolean[][][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		copy_arr = new int[n][m];
		visited = new boolean[n][m][2];
		cnt = 1;//벽을 부수면 0, 안부수면 1
		
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = (int)str.charAt(j)-'0';
				copy_arr[i][j] = arr[i][j];
			}
		}
		
		bfs(0, 0);
	}
	
	public static class Pair{
		int x;
		int y;
		int dis;
		boolean crush;
		public Pair(int x, int y, int dis, boolean crush) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.crush = crush;
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y, 1, false));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			x = cur.x;
			y = cur.y;
			
			if(x==n-1 && y==m-1) {
				System.out.println(cur.dis);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx <= -1 || nx >= n|| ny <= -1 || ny >=m) {
					continue;
				}
				
				int next_dis = cur.dis + 1;
				
				if(arr[nx][ny]==1) {//벽이라면
					if(!cur.crush && !visited[nx][ny][1]) {
						q.add(new Pair(nx, ny, next_dis, true));
						visited[nx][ny][1] = true;
					}
				}
				if(arr[nx][ny]==0) {//벽이 아니라면
					if(!cur.crush && !visited[nx][ny][0]) {//벽을 부순 적 없다면
						q.add(new Pair(nx, ny, next_dis, false));
						visited[nx][ny][0] = true;
					} else if(cur.crush && !visited[nx][ny][1]) {//벽을 부순 적 있다면
						q.add(new Pair(nx, ny, next_dis, true));
						visited[nx][ny][1] = true;
					}
				}
			}
			
		}
		System.out.println(-1);
	}
}
