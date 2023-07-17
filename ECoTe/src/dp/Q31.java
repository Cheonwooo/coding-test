package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q31 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][m];
			
			st = new StringTokenizer(br.readLine());
			
			int idx = 0;
			while(st.hasMoreTokens()) {
				for(int j=0; j<m; j++) {
					arr[idx][j] = Integer.parseInt(st.nextToken());
				}
				idx++;
			}
			
			for(int j=1; j<m; j++) {
				for(int k=0; k<n; k++) {
					if(k==0) {
						arr[k][j] = Math.max(arr[k][j-1]+arr[k][j], arr[k+1][j-1]+arr[k][j]);
					} else if(k==n-1) {
						arr[k][j] = Math.max(arr[k][j-1]+arr[k][j], arr[k-1][j-1]+arr[k][j]);
					} else {
						int max = Math.max(arr[k+1][j-1], Math.max(arr[k-1][j-1], arr[k][j-1]));
						arr[k][j] = max + arr[k][j];
					}
				}
			}
			
			int max = arr[0][m-1];
			for(int j=1; j<n; j++) {
				max = Math.max(max, arr[j][m-1]);
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
		
	}

}
