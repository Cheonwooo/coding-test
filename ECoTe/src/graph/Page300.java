package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
 */

public class Page300 {
	public static int n, m;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> list = new ArrayList<Edge>();
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int cost;
		
		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		public int getA() {
			return a;
		}

		public int getB() {
			return b;
		}

		public int getCost() {
			return cost;
		}
		
		public int compareTo(Edge other) {
			if(this.cost < other.cost) {
				return -1;
			} else if(this.cost > other.cost) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
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
		
		for(int i=0; i<n+1; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a, b, c));
		}
		
		Collections.sort(list);
		int result = 0;
		int max = 0;
		
		for(int i=0; i<list.size(); i++){			
			int a = list.get(i).getA();
			int b = list.get(i).getB();
			int cost = list.get(i).getCost();
			
			if(findParent(a) != findParent(b)) {
				unionParent(a,b);
				max = cost;
				result += cost;
			}
		}
		System.out.println(result-max);
	}
}
