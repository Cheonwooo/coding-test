package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16236 {
	public static int n;
	public static int[][] map;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1}; 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		Queue<Fish> q = new LinkedList<>();
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					q.add(new Fish(i, j, 0));
					map[i][j] = 0;
				}
			}
		}
		
		
		
		int cnt = 0;
		int eat = 0;
		int size = 2;//상어의 사이즈
		
		while(true) {
			PriorityQueue<Fish> pq = new PriorityQueue<>(new Comparator<Fish>() {
				public int compare(Fish o1, Fish o2) {
					if(o1.dist == o2.dist && o1.x == o2.x) {
						return o1.y - o2.y;
					} else if(o1.dist == o2.dist) {
						return o1.x - o2.x;
					}
					return o1.dist - o2.dist;
				}
			});
			
			int[][] dist = new int[n][n];
			
			while(!q.isEmpty()) {
				Fish cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				
				
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					
					
					if(nx>=0 && nx<n && ny>=0 && ny<n && dist[nx][ny]==0 && map[nx][ny] <= size) {
						dist[nx][ny] = dist[x][y] + 1;
						q.add(new Fish(nx, ny, dist[nx][ny]));
						
						if(map[nx][ny] >= 1 && map[nx][ny] <= 6 && map[nx][ny] < size) {
							pq.add(new Fish(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
			
			if(pq.size()==0) {
				System.out.println(cnt);
				break;
			}
			
			Fish now = pq.poll();
			cnt += now.dist;
			eat++;
			map[now.x][now.y] = 0;
			if(eat == size) {
				size++;
				eat = 0;
			}
			
			q.add(new Fish(now.x, now.y, 0));
		}
		
		
		
	}
	
	public static void fishFood(int cnt, int size) {
		if(cnt==size) {
			size++;
		}
	}
	
	public static class Fish{
		int x;
		int y;
		int dist;
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getDist() {
			return dist;
		}

		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
	}
}
