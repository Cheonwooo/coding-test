package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex15685 {
	
	public static int x, y, d, g;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, -1, 0, 1};
	public static int[][] map;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[100][100];
		visited = new boolean[101][101];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			
			dragonCurve();
		}
		
		int answer = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(visited[i][j] && visited[i+1][j] && visited[i][j+1] && visited[i+1][j+1]) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void dragonCurve() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(d);
		
		for(int i=1; i<=g; i++) {
			for(int j=list.size()-1; j>=0; j--) {
				list.add((list.get(j)+1) % 4);
			}
		}
		
		visited[y][x] = true;
		for(int direction : list) {
			x += dx[direction];
			y += dy[direction];
			visited[y][x] = true;
		}
	}
}
