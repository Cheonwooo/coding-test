package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q20 {
	public static int n, max;
	public static boolean answer;
	public static String[][] map, temp;
	public static boolean[][] visited;
	public static ArrayList<Pair> stu = new ArrayList<Pair>(); 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new String[n][n];
		temp = new String[n][n];
		visited = new boolean[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = st.nextToken();
				temp[i][j] = map[i][j];
				
				if(map[i][j].equals("S")) {
					stu.add(new Pair(i, j));
				}
			}
		}
		max = Integer.MIN_VALUE;
		wall(0);
		
		if(max==0) System.out.println("YES");
		else System.out.println("NO");
	}
	
	public static void wall(int count) {
		if(count == 3) {
			answer = false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					temp[i][j] = map[i][j];
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(temp[i][j].equals("S")) {						
						check(i,j);
					}
				}
			}
			if(!answer) {
				
				max = 0;
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j].equals("X")) {
					map[i][j] = "O";
					count += 1;
					wall(count);
					count -= 1;
					map[i][j] = "X";
				}
			}
		}
	}
	
	public static void check(int x, int y) {
		boolean[] shield = new boolean[4];
		for(int i=0; i<n; i++) {
			int[] dx = {-i, 0, i, 0};
			int[] dy = {0, i, 0, -i};
			
			for(int j=0; j<4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];
				
				if(nx<=-1 || nx>=n || ny<=-1 ||ny >=n || shield[j]) {
					continue;
				}
				if(temp[nx][ny].equals("O")) {
					shield[j] = true;
					continue;
				}
				if(temp[nx][ny].equals("T")) {//감시로부터 피하지 못했다면
					answer = true;
				}
			}
		}
		return;
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
