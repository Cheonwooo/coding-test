package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//파라메트릭 서치
public class Page197 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		int[] list = new int[m];
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			
			sb.append(parametric(arr, list[i], 0, arr.length-1)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	public static String parametric(int[] arr, int target, int start, int end) {
		while(start<end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == target) {
				return "yes";
			} else if(arr[mid] < target) {
				start = mid + 1;
			} else if(arr[mid] > target) {
				end = mid - 1;
			}
		}
		return "no";
	}

}
