package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex18111 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		int time = 99999999;
		int answer = 0;
		
		for(int i=min; i<=max; i++) {
			int cnt = 0;
			int block = b;
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(map[j][k]>i) {//블럭을 부셔야한다면
						cnt+=((map[j][k]-i)*2);
						block+=(map[j][k]-i);
					} else {//블럭을 쌓아야한다면

						block-= (i-map[j][k]);
						cnt+=(i-map[j][k]);
					}
					
				}
				
			}
			if(b<0) break;
			
			if(time>cnt) {
				time = cnt;
				answer = i;
			}

		}
		System.out.println(time + " " + answer);
	}
}
