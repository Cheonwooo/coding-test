package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise {
	public static int n;
	public static int[] arr, answer;
	public static boolean[] visited;

	public static void main(String args[]) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
//		n = Integer.parseInt(br.readLine());
		int[] arr = {6, 8, 7, 2, 1, 3, 5, 9, 4, 0};
		int[] arr1 = {6, 8, 7, 2, 1, 3, 5, 9, 4, 0};
		int[] arr2 = {6, 8, 7, 2, 1, 3, 5, 9, 4, 0};
		int[] arr3 = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
		
		sorting(arr);
		inserting(arr1);
		quick(arr2, 0, arr2.length-1);
		print(arr2);
		counting(arr3);
	}
	
	public static void sorting(int[] arr) {
		
		for(int i=0; i<arr.length-1; i++) {
			
			int min_idx = i;
			
			for(int j=i+1; j<arr.length; j++) {
				if(arr[min_idx] > arr[j]) {//가장 작은 원소의 인덱스 찾기
					min_idx = j;
				}
			}
			swap(arr, i, min_idx);
		}
		
		print(arr);
	}
	
	public static void inserting(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>0; j--) {
				if(arr[j] < arr[j-1]) {
					swap(arr, j, j-1);
				}
			}
		}
		print(arr);
	}
	
	public static void quick(int[] arr, int start, int end) {
		if(start>end) return;
		
		int pivot = start;
		int left = start + 1;
		int right = end;
		
		while(left <= right) {
			while(left <= end && arr[left] <= arr[pivot]) {
				left++;
			}
			while(right > start && arr[right] >= arr[pivot]) {
				right--;
			}
			if(left > right) {//엇갈렸다면 피벗과 작은값 스왑
				swap(arr, right, pivot);
			} else {
				swap(arr, left, right);
			}
		}
		//분할 이후 왼쪽, 오른쪽 각각 수행
		quick(arr, start, right-1);
		quick(arr, right+1, end);
	}
	
	public static void counting(int[] arr) {
		int[] count = new int[arr.length+1];
		
		for(int i=0; i<arr.length; i++) {
			count[arr[i]]++;
		}
		
		for(int i=0; i<count.length; i++) {
			while(count[i]!=0) {
				System.out.print(i + " ");
				count[i]--;
			}
		}
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public static void print(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " " );
		}
		System.out.println();
	}
}
