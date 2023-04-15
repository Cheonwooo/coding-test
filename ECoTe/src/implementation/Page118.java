package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page118 {
	
	public static int n, m, nx, ny;
	public static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());//방향
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {0, -1, 0, 1};//북동남서
		int[] dy = {-1, 0, 1, 0};
		
		arr[x][y] = 2;
		int cnt = 0;
		
		while(true) {

			if(!check(arr)) {//다 돌았다면
				break;
			}
			
			nx = x + dx[d];
			ny = y + dy[d];
			
			d++;
			if(d==4) d=0;
			
			if(arr[nx][ny]==1 || arr[nx][ny]==2) {
				continue;
			}
			if(arr[nx][ny]==0) {
				arr[nx][ny]=2;
				x = nx;
				y = ny;
				cnt++;
			}
		}
		
		if(d==0) d=3;
		else d-=1;
		
		while(arr[nx][ny]!=1) {
			nx += dx[d]*(-1);
			ny += dy[d]*(-1);
			System.out.println(nx +  " " + ny);
			cnt++;
		}
		System.out.println(cnt-1);
	}
	
	public static boolean check(int[][] arr) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==0) return true;//아직 0이 남았을경우
			}
		}
		
		return false;
	}
}
