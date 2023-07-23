package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/*
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
*/
 
public class Kruskal {
	public static int v, e, result;
	public static int[] parent = new int[100001];
	public static ArrayList<Edge> list = new ArrayList<Edge>();
	
	public static class Edge implements Comparable<Edge> {
		int nodeA;
		int nodeB;
		int distance;
		
		public Edge(int nodeA, int nodeB, int distance) {
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.distance = distance;
		}

		public int getNodeA() {
			return nodeA;
		}

		public int getNodeB() {
			return nodeB;
		}

		public int getDistance() {
			return distance;
		}
		
		public int compareTo(Edge other) {
			if(this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
	}
	
	public static int findParent(int x) {
		if(x == parent[x]) return x;
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
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<v+1; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a, b, cost));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			int a = list.get(i).getNodeA();
			int b = list.get(i).getNodeB();
			int cost = list.get(i).getDistance();
			
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
		}	
		System.out.println(result);
	}
}
