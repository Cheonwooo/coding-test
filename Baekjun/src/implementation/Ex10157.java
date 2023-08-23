package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10157 {
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		int[][] map = new int[m][n];
		
		int x = 0;
		int y = 0;
		map[x][y] = 1;
		if(k>n*m) {
			System.out.println(0);
		} else {
			int idx = 0;
			int cnt = 2;
			while(true) {
				
				if(cnt>n*m) break;
				
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				if(nx<0 || nx>=m || ny<0 || ny>=n || map[nx][ny]!=0) {
					idx++;
					idx %= 4;
					continue;
				}
				if(map[nx][ny]==0) {
					map[nx][ny]=cnt;
					cnt++;
					
					x = nx;
					y = ny;
				}
			}
			
//			for(int i=0; i<m; i++) {
//				for(int j=0; j<n; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] == k) {
						System.out.println((j+1) + " " + (i+1));
					}
				}
			}
		}
	}

}
 