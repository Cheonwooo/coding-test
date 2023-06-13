package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11047_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int i = arr.length-1;
		int sum = 0;
		while(k!=0) {
			if(k/arr[i] > 0) {//k가 arr[i]로 나눠진다면
				int cnt = k/arr[i];
				k = k - arr[i] * cnt;
				sum += cnt;
			} else {
				i--;
			}
		}
		System.out.println(sum);
	}

}
