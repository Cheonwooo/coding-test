package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q29 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr= new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int target = c;
		
		System.out.println(binarySearch(arr, target, 1, arr[n-1] - arr[0]));
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		int answer = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int home = arr[0];
			int cnt = 1;
			for(int i=0; i<arr.length;i ++) {
				int d = arr[i] - home;
				if(d >= mid) {
					cnt++;
					home = arr[i];
				}
			}
			
			if(cnt >= target) {
				answer = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return answer;
		
	}

}
