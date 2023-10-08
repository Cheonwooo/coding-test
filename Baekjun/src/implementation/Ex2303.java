package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2303 {
	public static int max;
	public static int answer = Integer.MIN_VALUE;
	public static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][5];
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] visited = new boolean[5];
			max = Integer.MIN_VALUE;
			comb(i, visited, 0, 3);
			
			if(answer<=max) {
				answer = max;
				cnt = i+1;
			}
		}
		System.out.println(cnt);
	}

	public static void comb(int num, boolean[] visited, int depth, int r) {
		if(depth==r) {
			int sum = 0;
			for(int i=0; i<5; i++) {
				if(visited[i]) {
					sum += arr[num][i];
				}
			}
			max = Math.max(max, sum%10);
			return;
		}
		for(int i=0; i<5; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(num, visited, depth+1, r);
				visited[i] = false;
			}
		}
	}
}
