package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex2751 {

	/*public static void selection_sort(int[] a, int size) {
		for(int i=0; i<size-1; i++) {
			int min_index = i;
			
			for(int j=i+1; j<size; j++) {
				if(a[j] < a[min_index]) {
					min_index = j;
				}
			}
			swap(a, min_index, i);
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		
		for(int i=0; i<n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		for(int i=1; i<10001; i++) {
			while(arr[i]>0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
		}
		System.out.println(sb);
		
		/*int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[j]<arr[i]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for(int val : arr) {
			System.out.println(val);
		}*/
		
	}

}
