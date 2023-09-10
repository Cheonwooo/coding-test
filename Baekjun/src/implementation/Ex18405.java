package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex18405 {
	public static class Virus implements Comparable<Virus>{
		int x;
		int y;
		int virus;
		
		public Virus(int x, int y, int virus) {
			this.x = x;
			this.y = y;
			this.virus = virus;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}

		public final int getVirus() {
			return virus;
		}
		
		public int compareTo(Virus o) {
			return this.virus - o.virus;
		}
	}
	
	public static Queue<Virus> q = new LinkedList<>();
	public static int n;
	public static int[][] arr;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		
		PriorityQueue<Virus> pq = new PriorityQueue<>();
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) {
					pq.offer(new Virus(i, j, arr[i][j]));
				}
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());		
		
		if(s!=0) {
			s--;
			while(!pq.isEmpty()) {
				Virus now = pq.poll();
				
				int nx = now.getX();
				int ny = now.getY();
				int virus = now.getVirus();

				bfs(nx, ny ,virus);
			}

			while(true) {
				if(s==0) break;
				s--;
				
				int size = q.size();
				for(int i=0; i<size; i++) {
					Virus now = q.poll();
					
					int nx = now.getX();
					int ny = now.getY();
					int virus = now.getVirus();
					
					bfs(nx, ny ,virus);
				}
			}
		}
		
		if(arr[x][y]!=0) {
			System.out.println(arr[x][y]);
		} else {
			System.out.println(0);
		}
		
	}
	public static void bfs(int x, int y, int virus) {
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<1 || nx>n || ny<1 || ny>n || arr[nx][ny]!=0) continue; 
			
			if(arr[nx][ny]==0) {
				arr[nx][ny] = virus;
				q.add(new Virus(nx, ny, virus));
			}
		}
	}
}
