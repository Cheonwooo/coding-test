package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2740 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr2 = new int[m][k];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<k; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] answer = new int[n][k];
		
		for(int i=0; i<n; i++) {
			for(int l=0; l<k; l++) {
				int sum = 0;
				for(int p=0; p<m; p++) {
					sum += arr1[i][p] * arr2[p][l];
				}
				answer[i][l] = sum;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
		
}
