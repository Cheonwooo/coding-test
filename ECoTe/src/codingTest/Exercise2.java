package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
	public static int r, max;
	public static String[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		boolean[] visited = new boolean[n];
		int[] output = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(arr, output, visited, 0, n, 5);
			
	}
	
	public static void comb(int[] arr, int[] output,boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			for(int i=0; i<r; i++) {
				System.out.print(output[i] + " " );
			}
			System.out.println();
			return;
		}
			
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				comb(arr, output, visited, depth+1, n, r);
				visited[i] = false;
			}
		}
	}
}
