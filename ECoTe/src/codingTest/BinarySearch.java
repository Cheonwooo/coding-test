package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		BinarySearch1(arr, target, 0, arr.length-1);
		BinarySearch2(arr, target, 0, arr.length-1);
	}

	public static void BinarySearch1(int[] arr, int target, int start, int end) {
		if(start > end) {
			System.out.println("원소가 존재하지 않습니다.");
			return;
		}
		
		int mid = (start + end) / 2;
		
		if(arr[mid] == target) {
			System.out.println(mid);
			return;
		} else if(arr[mid] > target) {
			BinarySearch1(arr, target, start, mid-1);
		} else if(arr[mid] < target) {
			BinarySearch1(arr, target, mid+1, end);
		}
	}
	
	public static void BinarySearch2(int[] arr, int target, int start, int end) {
		while(start<end) {
			int mid = (start + end / 2) ;
			
			if(arr[mid] == target) {
				System.out.println(mid);
				return;
			} else if(arr[mid] > target) {
				end = mid - 1;
			} else if(arr[mid] < target) {
				start = mid + 1;
			}
		}
		
		System.out.println("원소가 존재하지 않습니다.");
		return;
	}
}
