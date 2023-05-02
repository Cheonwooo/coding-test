package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex15649 {
	public static int n, m;
	public static int[] arr, new_arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		/*m = Integer.parseInt(st.nextToken());*/
		
		st = new StringTokenizer(br.readLine());
		visited = new boolean[n];
		arr = new int[3];
		new_arr = new int[n];
		
		for(int i=0; i<n; i++) {
			new_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(new_arr);
		check(0);
		
	}

	public static void check(int count) {
		if(count == 3) {
			for(int v : arr) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]){
				visited[i] = true;
				arr[count] = new_arr[i];
				check(count + 1);
				visited[i] = false;
			}
		}
	}
}
