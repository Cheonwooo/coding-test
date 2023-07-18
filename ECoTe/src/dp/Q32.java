package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */
public class Q32 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		arr[0][0] = Integer.parseInt(br.readLine());
		for(int i=1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
			int max = 0;
			for(int i=1; i<n; i++) {
				for(int j=0; j<=i; j++) {
					int upLeft, up;
					
					if(j==0) upLeft = 0;
					else upLeft = arr[i-1][j-1];
					if(j==i) up = 0;
					else up = arr[i-1][j];
					arr[i][j] = arr[i][j] + Math.max(upLeft, up);
				}
			}
			int answer = 0;
			for(int i=0; i<n; i++) {
				answer = Math.max(answer, arr[n-1][i]);
			}
			System.out.println(answer);
		}

}
