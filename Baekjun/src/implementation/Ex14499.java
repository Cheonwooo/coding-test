package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14499 {
	public static int n, m, x, y, k;
	public static int[] cmd;
	public static int[][] map, dice;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cmd = new int[k];
		dice = new int[4][3]; 
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int d = Integer.parseInt(st.nextToken())-1;
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx<0 || nx>=n || ny<0 || ny>=m) {
				continue;
			}
			change(d);//먼저 굴림
			
			if(map[nx][ny]==0) {
				map[nx][ny] = dice[3][1];
			} else {//0이 아니라면
				dice[3][1] = map[nx][ny];
				map[nx][ny] = 0;
			}

			sb.append(dice[1][1]).append("\n");
			x = nx;
			y = ny;
		}
		System.out.println(sb);
	}
	
	public static void change(int x) {
		if(x==0) {//동
			int temp = dice[1][1];
			dice[1][1] = dice[1][0];
			dice[1][0] = dice[3][1];
			dice[3][1] = dice[1][2];
			dice[1][2] = temp;
		} else if(x==1) {
			int temp = dice[1][1];
			dice[1][1] = dice[1][2];
			dice[1][2] = dice[3][1];
			dice[3][1] = dice[1][0];
			dice[1][0] = temp;
		} else if(x==2) {//북
			int temp = dice[1][1];
			dice[1][1] = dice[2][1];
			dice[2][1] = dice[3][1];
			dice[3][1] = dice[0][1];
			dice[0][1] = temp;
		} else if(x==3) {//남
			int temp = dice[1][1];
			dice[1][1] = dice[0][1];
			dice[0][1] = dice[3][1];
			dice[3][1] = dice[2][1];
			dice[2][1] = temp;
		}
	}
}
