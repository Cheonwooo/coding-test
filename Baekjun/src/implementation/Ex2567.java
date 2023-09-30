package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2567 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[101][101];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					map[j][k] = true;
				}
			}
		}
		int answer = 0;
		for(int i=1; i<101; i++) {
			for(int j=1; j<101; j++) {
				if(map[i][j]) {
					for(int p=0; p<4; p++) {
						int nx = i + dx[p];
						int ny = j + dy[p];
						
						if(nx<1 || nx>100 || ny<1 || ny>100) answer++;
						else if(!map[nx][ny]) answer++;
					}
				}
			}
		}
		
		System.out.println(answer);
	}

}
