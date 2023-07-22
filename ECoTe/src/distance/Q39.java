package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q39 {
	public static final int INF = (int) 1e9;
	public static int n;
	public static int[][] arr;
	public static int[][] d = new int[125][125];
	public static boolean[][] visited = new boolean[125][125];
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	
	public static class Node implements Comparable<Node>{
		int x;
		int y;
		int dist;
		
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getDist() {
			return dist;
		}
		public int compareTo(Node other) {
			if(this.dist < other.dist) {
				return -1;
			}
			return 1;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			
			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<n; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j=0; j<n; j++) {
				Arrays.fill(d[j], INF);
			}
			
			
			
			int x = 0, y = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			
			pq.offer(new Node(0, 0, arr[x][y]));
			d[x][y] = arr[x][y];
			
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				
				x = node.getX();
				y = node.getY();
				int dist = node.getDist();
				
				if(d[x][y] < dist) continue;
				
				for(int j=0; j<4; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
					
					int cost = dist + arr[nx][ny];
					
					if(cost < d[nx][ny]) {
						d[nx][ny] = cost;
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			System.out.println(d[n-1][n-1]);
		}
	}
	

}
