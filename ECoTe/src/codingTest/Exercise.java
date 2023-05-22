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
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		answer = new int[3];
		visited = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		permutation(0);
		combination(0, 0);
		subset(0);
	}
	
	public static void permutation(int idx) {
		if(idx == answer.length) {
			for(int i=0; i<answer.length; i++) {
				System.out.print(answer[i] + " " );
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<arr.length;i++) {
			if(!visited[i]) {
				answer[idx] = arr[i];
				
				visited[i] = true;
				permutation(idx + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void combination(int arridx, int idx) {
		if(idx==answer.length) {
			for(int i=0; i<answer.length; i++) {
				System.out.print(answer[i] + " " );
			}
			System.out.println();
			return;
		}
		
		if(arridx==arr.length) return;
		
		answer[idx] = arr[arridx];
		
		combination(arridx+1 , idx+1);
		combination(arridx+1 , idx);
	}
	
	public static void subset(int idx) {
		if(idx == arr.length) {
			for(int i=0; i<arr.length; i++) {
				if(visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		visited[idx] = true;
		subset(idx + 1);
		visited[idx] = false;
		subset(idx + 1);
	}
}
