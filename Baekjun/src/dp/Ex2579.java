package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2579 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] sum = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		if(n==1) {
			System.out.println(arr[0]);
		} else if(n==2) {
			System.out.println(arr[0]+arr[1]);
		} else {
			sum[0] = arr[0];
			sum[1] = arr[0] + arr[1];
			sum[2] = Math.max(arr[0], arr[1]) + arr[2];
			
			for(int i=3; i<n; i++) {
				sum[i] = Math.max(sum[i-3] + arr[i-1], sum[i-2]) + arr[i];
			}
			
			System.out.println(sum[n-1]);

		}
	}

}
