package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex3273 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int lo = 0;
		int hi = arr.length-1;
		int sum;
		int cnt = 0;
		while(lo<hi) {
			sum = arr[lo] + arr[hi];
			
			if(sum > ans) { //sum이 ans보다 크면 hi감소
				hi--;
			} else if(sum < ans) { //sum이 ans보다 작으면 lo 증가
				lo++;
			} else { //sum==ans
				cnt++;
				lo++;
			}
		}
		System.out.println(cnt);
		
	}

}
