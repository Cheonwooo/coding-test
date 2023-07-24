package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex13460 {
	public static Queue<Pair> q = new LinkedList<>();
	public static int n, m;
	public static int[][] temp;
	public static String[][] map;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0,1,0,0-1};
	
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

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new String[n][n];
		temp = new int[n][n];
		
		int xO = 0;
		int yO = 0;
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<n; j++) {
				map[i][j] = str[j];
				if(map[i][j].equals("R")) {
					q.offer(new Pair(i, j));
				} else if(map[i][j].equals("O")) {
					xO = i;
					yO = j;
				}
			}
		}
		bfs();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " " );
			}
			System.out.println();
		}
		
		
	}
	public static void bfs() {
		
		while(!q.isEmpty()) {
			Pair now = q.poll();
			
			int x = now.getX();
			int y = now.getY();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) {
					continue;
				}
				if(map[nx][ny].equals("#")) {
					continue;
				}
				
				if(map[nx][ny].equals(".")) {
					map[nx][ny] = "c";
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}
}
