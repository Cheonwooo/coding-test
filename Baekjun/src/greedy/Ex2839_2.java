package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2839_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		
		if(n>=3) {
			arr[3] = 1;
		} 
		if(n>=5) {
			arr[5] = 1;
		}
		for(int i=6; i<arr.length; i++) {
			if(i%5==0) {
				arr[i] = arr[i-5] + 1;
			} else if(i%3==0) {
				arr[i] = arr[i-3] + 1; 
			} else {
				if(arr[i-3] != 0 && arr[i-5] != 0) {
					arr[i] = Math.min(arr[i-3], arr[i-5]) + 1;
				}
			}
		}
		if(arr[n]==0) {
			System.out.println(-1);
		} else {
			System.out.println(arr[n]);
		}
		
	}

}
