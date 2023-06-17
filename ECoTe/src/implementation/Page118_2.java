package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page118_2 {
	public static int d;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[x][y] = 2;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int turn_time = 0;
		int cnt = 0;
		
		while(true) {
			
			turn_left();
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(map[nx][ny]==0) {
				map[nx][ny]=2;
				
				x = nx;
				y = ny;
				cnt++;
				turn_time = 0;
			} else {
				turn_time++;
			}
			if(turn_time==4) {//네방향 모두 가봤을 경우
				nx = x - dx[d];
				ny = y - dy[d];
				
				if(map[nx][ny]==2) {
					cnt++;
					x = nx;
					y = ny;
				} else {
					break;
				}
				turn_time=0;
			}
		}
		System.out.println(cnt);
	}
	
	public static void turn_left() {
		d -= 1;
		
		if(d==-1) d=3;
		
	}

}
