package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Page201 {
	public static int n;
	public static long m;
	public static PriorityQueue<Long> pq = new PriorityQueue<Long>(Collections.reverseOrder()); 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Long.parseLong(st.nextToken());
		
		long[] arr = new long[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long end = arr[arr.length-1];
		
		binarySearch(arr, m, 0, end);
		
		System.out.println(pq.poll());
	}

	public static void binarySearch(long[] arr, long target, long start, long end) {
		while(start < end) {
			long mid = (start + end) / 2;
			
			long sum = 0;
			for(int i=0; i<arr.length; i++) {
				if(mid-arr[i] < 0) {
					sum += (long)Math.abs(mid-arr[i]);
				}
			}
			
			if(sum >= target) { //총합이 더 크다면 mid값을 올려야함
				pq.add(mid);
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}

	
}
