package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q33 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n+1][2];
		int[] d = new int[101];
		
		for(int i=1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			
			for(int j=i+arr[i][0]; j<d.length; j++) {
				d[j] = Math.max(d[j], d[i] + arr[i][1]);
			}
		}

		int result = 0;
		for(int i=1; i<=n+1; i++) {
			result = Math.max(result, d[i]);
		}
		System.out.println(result);
	}

}
