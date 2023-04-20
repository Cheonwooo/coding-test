package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex10815 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(arr);
		int M = Integer.parseInt(br.readLine());
		int[] list = new int[M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.length; i++) {
			list[i] = Integer.parseInt(st2.nextToken());
			if(binarySearch(arr, list[i])) {
				sb.append(1).append(' ');
			} else {
				sb.append(0).append(' ');
			}
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean binarySearch(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right) {
			int mid = (left+right)/2;
			if(arr[mid] < num) {
				left = mid + 1;
			} else if(arr[mid] > num) {
				right = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
