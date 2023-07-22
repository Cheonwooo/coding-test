package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
 */
public class FloydWarshall {
	public static final int INF = (int) 1e9;
	public static int n, m;
	public static int[][] graph = new int[501][501];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<501; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) graph[i][j] = 0;
			}
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a][b] = c;
		}
		
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(graph[i][j]==INF) {
					System.out.print("INFINITY" + " ");
				} else{
					System.out.print(graph[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}

}
