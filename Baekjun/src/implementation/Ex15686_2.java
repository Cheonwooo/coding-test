package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15686_2 {
	public static int n, k, ch;
	public static int[][] map, temp;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		temp = new int[n][n];
		visited = new boolean[n][n];
		ch = 0;//치킨집(chicken_home)의 개수
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==2) ch++;
				
			}
		}
	}
	
	public static void dfs(int cnt) {
		if(cnt==k) { //ch중에서 k개를 골랐을 때
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					temp[i][j] = map[i][j];
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==2 && !visited[i][j]) {
					visited[i][j] = true;
					cnt += 1;
					dfs(cnt);
					visited[i][j] = false;
					cnt -= 1;
				}
			}
		}
	}

}
