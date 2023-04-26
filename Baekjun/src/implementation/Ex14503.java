package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14503 {
	
	public static int n, m, x, y, d, cnt, nx, ny, num;
	public static int[][] arr;
	public static int[] dx = {-1, 0, 1, 0};//북동남서
	public static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken()); 
		y = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0;
		num = 0;
		while(true) {//청소 다하기
			
			//청소가 다 끝나지 않았다면
			
			//현재 위치가 청소되지 않은 경우
			//현재 위치의 값을 2로 변경
			if(arr[x][y]==0) {
				arr[x][y]=2;
				cnt++;
			}
			
			//반시계 방향으로 90도 회전
			//nx, ny, d값 변경됨
			turn_left();
			
			if(arr[nx][ny]==0) {
				x = nx;
				y = ny;
				num = 0;
			}
			if(num==4) {//주변 4칸이 청소되지 않은 빈 칸이 없는 경우
				if(arr[x-dx[d]][y-dy[d]]!=1) {//벽이 아니라면 후진
					x -= dx[d];
					y -= dy[d];
					num = 0;
				} else if(arr[x-dx[d]][y-dy[d]]==1) {//뒤가 벽이라면 스탑
					break;
				}
			}
		}
		/*for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j] + " " );
			}
			System.out.println();
		}*/
		
		System.out.println(cnt);
	}
	
	public static void turn_left() {
		if(d==0) d=3;
		else d -= 1;
		
		nx = x + dx[d];
		ny = y + dy[d];
		num++;
	}
	
	public static boolean check() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==0) return false;//아직 청소가 다 끝나지 않은 경우 false
			}
		}
		return true;
	}
}
