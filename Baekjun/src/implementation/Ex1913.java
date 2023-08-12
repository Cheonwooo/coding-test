package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1913 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		
		int[][] map = new int[n][n];
		int start = n*n;
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int x = 0;
		int y = 0;
		int d = 0;
		int answerX = 0;
		int answerY = 0;
		while(true) {
			
			if(start==0) break;
			
			map[x][y] = start--;
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			
			if(nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny]!=0) {
				
				d++;
				if(d==4) d=0;
				x+=dx[d];
				y+=dy[d];
			} else{
				x = nx;
				y = ny;
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(map[i][j]).append(" ");
				if(map[i][j]==num) {
					answerX=i+1;
					answerY=j+1;
				}
			}
			sb.append("\n");
		}
		sb.append(answerX).append(" ").append(answerY);
		
		System.out.println(sb);
	}

}
