package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11 {
	public static int n;
	public static int[][] map;
	public static boolean[][] apple, visited;
	public static int[] dx = {-1, 0, 1, 0};//북,동,남,서
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		apple = new boolean[n][n];
		visited = new boolean[n][n];
		
		StringTokenizer st;
		
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			apple[x][y] = true;
		}
		
		int l = Integer.parseInt(br.readLine());
		ArrayList<Direction> list = new ArrayList<>();
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			list.add(new Direction(count, dir));
		}
		
		int cnt = 0;
		int d = 1;
		int x = 0;
		int y = 0;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		visited[x][y] = true;
		
		int idx = 0;
		while(true) {
			if(cnt==list.get(idx).count) {
				
				if(list.get(idx).dir.equals("D")) {
					d++;
					if(d==4) d=0;
				} else {
					d--;
					if(d==-1) d=3;
				}
				idx++;
				if(idx==list.size()) idx = 0;
			}
			
			
			boolean check = false;
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			cnt++;
			if(nx<=-1 || nx>=n || ny<=-1 || ny>=n) {
				check = true;
				break;
			}
			if(visited[nx][ny]) {
				check = true;
				break;
			}
			
			if(apple[nx][ny]) {//사과가 있다면
				q.add(new Pair(nx, ny));
				visited[nx][ny] = true;
				apple[nx][ny] = false;
				
				x = nx;
				y = ny;
			} else {//사과가 없다면
				q.add(new Pair(nx, ny));
				visited[nx][ny] = true;
				
				x = nx;
				y = ny;
				
				Pair cur = q.poll();
				int cx = cur.x;
				int cy = cur.y;

				visited[cx][cy] = false;
			}
			
			if(check) break;
		}
		System.out.println(cnt);
		
	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static class Direction{
		int count;
		String dir;
		
		public Direction(int count, String dir) {
			this.count = count;
			this.dir = dir;
		}
	}
}
