package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17 {
	public static int n, k;
	public static int[][] map;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static PriorityQueue<Virus> pq = new PriorityQueue<>();
	public static Queue<Virus> q = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]!=0) {
					pq.add(new Virus(map[i][j], i, j));
				}
				
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		
		int cnt = 0;
		
		while(cnt!=s) {
			
			while(!pq.isEmpty()) {
				Virus v = pq.poll();
				
				bfs(v.x, v.y, v.virus);
			}
			while(!q.isEmpty()) {
				Virus v = q.poll();
				
				pq.add(new Virus(v.virus, v.x, v.y));
			}
			cnt++;
		}
		
		
		if(map[x][y]!=0) {
			System.out.println(map[x][y]);
		} else {
			System.out.println(0);
		}
		
	}
	
	public static void bfs(int x, int y, int k) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<=-1 || nx>=n || ny<=-1 || ny>=n) {
				continue;
			}
			if(map[nx][ny]==0) {
				map[nx][ny]=k;
				q.add(new Virus(k, nx, ny));
			}
		}
	}
	
	public static class Virus implements Comparable<Virus>{
		int virus;
		int x;
		int y;
		
		public Virus(int virus, int x, int y) {
			this.virus = virus;
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Virus o) {
			return this.virus - o.virus;
		}
	}
}
