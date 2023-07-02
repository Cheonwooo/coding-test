package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21 {
	public static int n, l, r, cnt, idx;
	public static int[][] map, temp;
	public static boolean[][] visited;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt=0;
		move();
		System.out.println(cnt-1);
	}
	
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<=-1 || nx>=n || ny<=-1 || ny>=n) {
				continue;
			}
			if(Math.abs(map[x][y] - map[nx][ny]) >= l &&
					Math.abs(map[x][y] - map[nx][ny]) <= r ) {
				if(!visited[x][y]) {
					visited[x][y] = true;
				}
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
				}

			}
		}
	}
	
	public static boolean dfs2(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=n) {
			return false;
		}
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<=-1 || nx>=n || ny<=-1 || ny>=n) {
				continue;
			}
			
			if(Math.abs(map[x][y] - map[nx][ny]) >= l &&
					Math.abs(map[x][y] - map[nx][ny]) <= r) {
				
				if(!visited[x][y]) {
					visited[x][y] = true;
					temp[x][y] = idx;
				}
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					temp[nx][ny] = idx;
				}
				
				dfs2(nx, ny);
				return true;
			}
			
		}
		
		return false;
	}
	
	public static void move() {
		while(true) {
			visited = new boolean[n+1][n+1];
			temp = new int[n+1][n+1];
			
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					dfs(i, j);
//				}
//			}
			if(idx==1) break;//더이상 이동할 수 없다면 끝
			cnt++;
			
			idx = 1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(dfs2(i, j)) idx++;
				}
			}
			
			Queue<Pair> q = new LinkedList<>();
			for(int i=1; i<idx; i++) {
				int sum = 0;
				for(int j=0; j<n; j++) {
					for(int k=0; k<n; k++) {
						if(temp[j][k]==i) {
							q.offer(new Pair(j, k));
							sum += map[j][k];
						}
					}
				}
				sum /= q.size();
				
				while(!q.isEmpty()) {
					Pair now = q.poll();
					int nx = now.x;
					int ny = now.y;
					
					map[nx][ny] = sum;
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(temp[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			
		}
		
	}
	
	public static boolean check() {
		boolean exit = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j]) {//이동을 계속 할 수 있다면
					exit = true;
				}
			}
		}
		return exit;
	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
