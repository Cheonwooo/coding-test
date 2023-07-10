package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q28 {
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	public static int answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		binarySearch(arr, 0, arr.length-1);
		
		if(answer != Integer.MIN_VALUE) {
			System.out.println(answer);
		} else if(answer == Integer.MIN_VALUE) {
			System.out.println(-1);
		}
	}

	public static void binarySearch(int[] arr, int start ,int end) {
		
		if(start > end) {
			return;
		}
		int mid = (start + end) / 2;
		
		if(arr[mid] == mid) {
			answer = mid;
			return;
		} else if(arr[mid]!=mid) {
			binarySearch(arr, start, mid-1);
			binarySearch(arr, mid+1, end);
		}
		return;
	}
}
