package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex20056 {
	public static class Shark {
		int r;
		int c;
		int m;
		int s;
		int d;
		int cnt;

		public Shark(int r, int c, int m, int s, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.cnt = cnt;
		}

		public final int getR() {
			return r;
		}

		public final int getC() {
			return c;
		}

		public final int getM() {
			return m;
		}

		public final int getS() {
			return s;
		}

		public final int getD() {
			return d;
		}

		public final int getCnt() {
			return cnt;
		}
		
	}

	public static int n;
	public static Shark[][] shark;
	public static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	public static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		shark = new Shark[n + 1][n + 1];

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			shark[r][c] = new Shark(r, c, m, s, d, 1);
		}
		
		for (int i = 0; i < k; i++) {

		}
	}

	public static void move() {
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(shark[i][j].getM()!=0) {//비어있는 값이 아니라면 움직임
					
					int x = i;
					int y = j;
					int s = shark[i][j].getS()%n;
					int d = shark[i][j].getD();
					for(int k=0; k<s; k++) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						
						if(nx==0) nx=n;
						if(nx==n) nx=0;
						if(ny==0) ny=n;
						if(ny==n) ny=0;
						
						x = nx;
						y = ny;
					}
					
					
				}
			}
		}
	}
}
