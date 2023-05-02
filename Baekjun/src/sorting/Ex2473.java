package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2473 {
	public static long min = 3000000000L;
	public static long[] arr, save_arr = new long[3];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new long[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n-2; i++) {
			check(i);
		}
		
		System.out.print(save_arr[0] + " " + save_arr[1] + " " + save_arr[2]);
	}
	
	public static void check(int idx) {
		int lo = idx + 1;
		int hi = arr.length-1;
		
		while(lo < hi) {
			long sum = arr[lo] + arr[hi] + arr[idx];
			long absSum = Math.abs(sum);
			
			if(absSum < min) {
				save_arr[0] = arr[idx];
				save_arr[1] = arr[lo];
				save_arr[2] = arr[hi];
				min = absSum;
			}
			
			if(sum>0) {
				hi--;
			} else {
				lo++;
			}
		}
	}
}
