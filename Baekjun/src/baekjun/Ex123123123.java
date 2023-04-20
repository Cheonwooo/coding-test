package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex123123123 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		int n = arr.length;
		boolean[] visited = new boolean[n];
		
		for(int i=0; i<=n; i++) {
			combination(arr,visited,0,n,i);
		}
		
		for(int i=0; i<=n; i++) {
			combination2(arr,visited,0,n,i);
		}
	}
	
	/*
	 * 백트래킹 사용
	 */
	public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r==0) {
			print(arr, visited, n);
			return;
		}
		
		for(int i=start; i<n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
	
	/*
	 * 재귀함수
	 */
	public static void combination2(int[] arr, boolean[] visited, int depth, int n, int r) {
		if(r==0) {
			print(arr, visited, n);
			return;
		}
		
		if(depth==n) {
			return;
		}
		
		visited[depth] = true;//depth 인덱스를 포함하여 뽑는 경우
		combination2(arr, visited, depth+1, n, r-1);
		
		visited[depth] = false;//depth 인덱스를 포함하지 않고 뽑는 경우
		combination2(arr, visited, depth+1, n, r);
	}
	
	public static void print(int[] arr, boolean[] visited, int n) {
		for(int i=0; i<n; i++) {
			if(visited[i]) {//visited[i]가 true면
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
	}
}
