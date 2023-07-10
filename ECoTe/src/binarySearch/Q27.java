package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q27 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Long.parseLong(st.nextToken());
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		long num = binarySearch(arr, x, 0, arr.length-1);
		
		if(num == 0) {
			System.out.println(-1);
		} else {
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(arr[i] == num) cnt++;
			}
			
			System.out.println(cnt);
		}	
	}
	
	public static long binarySearch(long[] arr, long target, int start, int end) {
		long answer = 0;
		
		while(start<end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == target) {
				answer = target;
				break;
			} else if(arr[mid] > target) {
				end = mid - 1;
			} else if(arr[mid] < target) {
				start = mid + 1;
			}
		}
		return answer;
	}
}
