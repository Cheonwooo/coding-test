package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1051 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		int answer = 1;
		
		for(int i=1; i<n; i++) {//한변의 길이 i+1
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(j+i<n && k+i<m && map[j][k] == map[j+i][k] &&
							map[j][k] == map[j][k+i] &&
							map[j][k] == map[j+i][k+i]) {
						answer = i+1;
					}
				}
			}
		}
		
		System.out.println(answer*answer);
	}

}
