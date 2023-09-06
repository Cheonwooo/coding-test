package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2564 {
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
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
	
	public static int n, m;
	public static Queue<Pair> q = new LinkedList<>();
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());//가로
		m = Integer.parseInt(st.nextToken());//세로
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int d = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			if(d==1) q.add(new Pair(0, dist));
			else if(d==2) q.add(new Pair(m, dist));
			else if(d==3) q.add(new Pair(dist, 0));
			else if(d==4) q.add(new Pair(dist, n));
		}
		
		st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int dist = Integer.parseInt(st.nextToken());
	
		
		int x = 0;
		int y = 0;
		int start = 0;
		if(d==1) {
			x = 0;
			y = dist;
			start = 1;
		}
		else if(d==2) {
			x = m;
			y = dist;
			start = 3;
		}
		else if(d==3) {
			x = dist;
			y = 0;
			start = 0;
		}
		else if(d==4) {
			x = dist;
			y = n;
			start = 2;
		}
		
		int answer = 0;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			int cx = cur.getX();
			int cy = cur.getY();
		
			int min = Integer.MAX_VALUE;
				
			answer += Math.min(forward(x, y, cx, cy, start), reverse(x, y, cx, cy, start));
			
		}
		System.out.println(answer);
	}

	public static int forward(int x, int y, int cx, int cy, int start) {
		int dir = start;
		int cnt = 0;
		int nx = x;
		int ny = y;
		while(true) {
			if(nx==cx && ny==cy) break;
			
			nx += dx[dir];
			ny += dy[dir];
//			System.out.println(nx + " " + ny);
			if(nx<0 || nx>m || ny<0 || ny>n) {
				nx -= dx[dir];
				ny -= dy[dir];
				
				dir++;
				dir%= 4;
				
			} else {
				cnt++;
			}
//			System.out.println(dir + " " + nx + " " + ny);
		}
		return cnt;
	}
	
	public static int reverse(int x, int y, int cx, int cy, int start) {
		int dir = (start+2)%4;
		int cnt = 0;
		int nx = x;
		int ny = y;
		while(true) {
			if(nx==cx && ny==cy) break;
			
			nx += dx[dir];
			ny += dy[dir];
			
			if(nx<0 || nx>m || ny<0 || ny>n) {
				nx -= dx[dir];
				ny -= dy[dir];
				
				dir--;
				if(dir==-1) dir = 3;
				
			} else {
				cnt++;
			}
		}
		return cnt;
	}
}
