package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q21_answer {
	public static int n, l, r;
	public static int[][] map, temp;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		temp = new int[n][n];
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					temp[i][j] = -1;
				}
			}
			
			int idx = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(temp[i][j]==-1) {
						run(i, j, idx);
						idx += 1;
					}
				}
			}
			if(idx == n*n)break;
			answer++;
		}
		System.out.println(answer);
	}
	
	public static void run(int x, int y, int idx) {
		Queue<Pair> q = new LinkedList<>();
		ArrayList<Pair> list = new ArrayList<Pair>();
		list.add(new Pair(x, y));
		
		q.add(new Pair(x,y));
		
		temp[x][y] = idx;
		int sum = map[x][y];
		int count = 1;
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			x = now.x;
			y = now.y;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<=-1 || nx>=n || ny<=-1 || ny>=n) {
					continue;
				}
				if(nx>=0 && nx<n && ny>=0 && ny<n &&temp[nx][ny] == -1) {
					int gap = Math.abs(map[nx][ny] - map[x][y]);
					if(gap>=l && gap<=r) {
						q.add(new Pair(nx, ny));
						temp[nx][ny] = idx;
						sum += map[nx][ny];
						count+=1;
						list.add(new Pair(nx, ny));
					}
				}
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			x = list.get(i).x;
			y = list.get(i).y;
			map[x][y] = sum/count;
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
}
