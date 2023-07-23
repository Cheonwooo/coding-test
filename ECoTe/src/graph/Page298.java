package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
public class Page298 {
	public static int n, m;
	public static int[] parent = new int[100001];
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
		
	}

	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n+1; i++) {
			parent[i] = i;
		}
		
		Queue<Pair> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int code = Integer.parseInt(st.nextToken()); 
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			
			if(code==0) {
				unionParent(a, b);
			} else if(code==1) {
				if(parent[a] == parent[b]) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);	
	}
}
