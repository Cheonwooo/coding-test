package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14503_2 {
	public static int d, turn_time;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0 , -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		if(map[r][c]==0) {
			map[r][c] = 2;
			cnt++;
		}
		turn_time=0;
		
		while(true) {
			turn_left();
			
			int nx = r + dx[d];
			int ny = c + dy[d];
			
			if(map[nx][ny]==0) {
				map[nx][ny] = 2;
				
				r = nx;
				c = ny;
				cnt++;
				turn_time=0;
				continue;
			} else {
				turn_time++;
			}
			
			if(turn_time==4) {
				nx = r - dx[d];
				ny = c - dy[d];
				
				if(map[nx][ny]==2) {
					r = nx;
					c = ny;
					turn_time = 0;
				} else {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void turn_left() {
		d-=1;
		
		if(d==-1) d = 3;
	}

}
