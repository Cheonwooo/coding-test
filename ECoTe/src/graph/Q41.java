package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3
 */

public class Q41 {
	public static int n, m;
	public static int[] parent = new int[501];
	
	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = parent[a];
		b = parent[b];
		if(a<b) parent[b] = a;
		else parent[a] = b;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][n+1];
		
		for(int i=0; i<n+1; i++) {
			parent[i] = i;
		}
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=i; j<n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) {
					unionParent(i, j);
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		boolean check = true;
		for(int i=0; i<list.size()-1; i++) {
			if(findParent(list.get(i)) != findParent(list.get(i+1))) {
				check = false;
			}
		}
		
		if(check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
