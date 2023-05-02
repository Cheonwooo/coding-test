package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1015 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] sorted = new int[1001];
		boolean[] visited = new boolean[1001];
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] ans = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sorted[num]++;
			arr[i] = num;
		}
		
		int idx = 0;
		while(n!=0) {
			int sum = 0;
			if(visited[arr[idx]]) {//이미 방문 했던 idx라면 sum+1
				sorted[arr[idx]-1]++;
				sorted[arr[idx]]--;
			}
			
			for(int i=0; i<arr[idx]; i++) {
				sum += sorted[i];
			}
			
			visited[arr[idx]] = true;
			ans[idx] = sum;
			idx++;
			n--;
		}
		StringBuilder sb = new StringBuilder();
		for(int v : ans) {
			sb.append(v).append(" ");
		}
		
		System.out.println(sb);
	}

}
