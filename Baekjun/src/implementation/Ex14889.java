package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14889 {
	public static int n;
	public static int min = Integer.MAX_VALUE;
	public static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[n];
		
		comb(n, visited, 0, 0, n/2);
		System.out.println(min);
	}

	public static void comb(int n,boolean[] visited, int start, int depth, int r) {
		
		if(depth==r) {
			int[] st = new int[n/2];
			int[] li = new int[n/2];
			
			int stIdx = 0;
			int liIdx = 0;
			for(int i=0; i<n; i++) {
				if(visited[i]) {
					st[stIdx] = i;
					stIdx++;
				} else {
					li[liIdx] = i;
					liIdx++;
				}
			}
			
			min = Math.min(min, score(st, li));
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(n, visited, i+1, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
	public static int score(int[] st, int[] li) {
		int sumA = 0;
		int sumB = 0;
		for(int i=0; i<st.length; i++) {
			for(int j=i+1; j<st.length; j++) {
				sumA += arr[st[i]][st[j]] + arr[st[j]][st[i]];
				sumB += arr[li[i]][li[j]] + arr[li[j]][li[i]];
			}
		}
		
		return (int)Math.abs(sumA-sumB);
	}
}
