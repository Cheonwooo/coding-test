package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10973 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		boolean answer = nextPermutation(arr);
		if(!answer) {
			System.out.println(-1);
		} else {
			for(int v : arr) {
				System.out.print(v + " ");
			}
		}
	}
	public static boolean nextPermutation(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1] <= arr[i]) i--;
		if(i<=0) return false;
		
		int j = arr.length-1;
		
		while(arr[j] >= arr[i-1]) j--;
		
		swap(arr,i-1, j);
		j = arr.length-1;
		while(i<j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		return true;
	}
	
	public static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
