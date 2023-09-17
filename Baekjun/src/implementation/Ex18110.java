package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex18110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n==0) {
			System.out.println(0);
		} else {
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(arr);
			
			int out = (int)Math.round(n*0.15);
			
			double sum = 0;
			int cnt = 0;
			
			for(int i=out; i<n-out; i++) {
				sum += arr[i];
				cnt++;
			}
			
			System.out.println((int)Math.round(sum/cnt));
		}
		
	}

}
