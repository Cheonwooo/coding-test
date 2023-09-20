package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex21610 {
	public static class Cloud{
		int x;
		int y;
		
		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}
		
	}
	
	public static int n;
	public static int[] dx = {-1, -1, 1, 1};
	public static int[] dy = {-1, 1, 1, -1};
	public static int[] mx = {0, -1, -1, -1, 0, 1, 1, 1};
	public static int[] my = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[][] map;
	public static boolean[][] visited;
	public static Queue<Cloud> q = new LinkedList<>();
	public static Queue<Cloud> water = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		q.offer(new Cloud(n-1, 0));
		q.offer(new Cloud(n-1, 1));
		q.offer(new Cloud(n-2, 0));
		q.offer(new Cloud(n-2, 1));
		
		for(int i=0; i<m; i++) {
			visited = new boolean[n][n];
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken())%n;
			
			move(d, s);
			plusWater();
			makeCloud();
		}
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}
	
	public static void move(int d, int s) {
		while(!q.isEmpty()) {
			Cloud cur = q.poll();
			
			int cx = cur.getX();
			int cy = cur.getY();
			
			int nx = (n + cx + mx[d]*s) % n;//n을 더해주는 이유는 음수의 값이 나왔을 때 때문
			int ny = (n + cy + my[d]*s) % n;
			
			map[nx][ny]++;
			visited[nx][ny] = true;//구름이 사라지는 자리 표시
			water.offer(new Cloud(nx, ny));
		}
	}
	
	public static void plusWater() {
		while(!water.isEmpty()) {
			Cloud cur = water.poll();
			
			int cx = cur.getX();
			int cy = cur.getY();
			
			int cnt = 0;
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny]==0) continue;
				
				cnt++;
			}
			map[cx][cy] += cnt;
		}
	}
	
	public static void makeCloud() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]>=2 && !visited[i][j]) {
					map[i][j] -= 2;
					q.offer(new Cloud(i, j));
				}
			}
		}
	}
}
