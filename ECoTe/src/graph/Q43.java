package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
 */

public class Q43 {
	
	public static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int cost;
		
		public Pair(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getCost() {
			return cost;
		}
		
		public int compareTo(Pair other) {
			if(this.cost < other.cost) {
				return -1;
			} else if(this.cost > other.cost) {
				return 1;
			}
			return 0;
		}
	}
	
	public static ArrayList<Pair> list = new ArrayList<Pair>();
	public static int[] parent = new int[200001];
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
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
		
		for(int i=0; i<n; i++) {
			parent[i] = i;
		}
		
		int sum = 0;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sum += z;
			list.add(new Pair(x, y, z));
		}
		
		Collections.sort(list);
		
		int result = 0;
		for(int i=0; i<list.size(); i++) {
			
			int x = list.get(i).getX();
			int y = list.get(i).getY();
			int cost = list.get(i).getCost();
			
			if(findParent(x) != findParent(y)) {
				unionParent(x, y);
				result += cost;
			}
		}
		System.out.println(sum - result);
	}

}
