package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Page259 {
	public static final int INF = (int) 1e9;
	public static int[][] arr = new int[101][101];
	public static int n, m;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n+1; i++) {
			Arrays.fill(arr[i], INF);
		}
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==j) {
					arr[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int a=1; a<n+1; a++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][a] + arr[a][j]);
				}
			}
		}
		
		
		int min = arr[1][k] + arr[k][x];
		
		if(min >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

}
