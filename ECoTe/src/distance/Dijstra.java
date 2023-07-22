package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijstra {
	
	public static final int INF = (int)1e9;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int n, m, start;
	public static int[] d = new int[100001];
	public static boolean[] visited = new boolean[100001];
	
	public static class Node{
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		public int getIndex() {
			return index;
		}
		public int getDistance() {
			return distance;
		}
	}
	
	public static int getSmallestNode() {
		int min_value = INF;
		int index = 0;
		for(int i=1; i<=n; i++) {
			if(d[i] < min_value && !visited[i]) {
				min_value = d[i];
				index = i;
			}
		}
		return index;
	}

	public static void dijkstra(int start) {
	
		d[start] = 0;
		visited[start] = true;
		
		for(int i=0; i<graph.get(start).size(); i++) {
			d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance(); 
		}
		
		for(int i=0; i<n-1; i++) {
			int now = getSmallestNode();
			visited[now] = true;
			
			for(int j=0; j<graph.get(now).size(); j++) {
				int cost = d[now] + graph.get(now).get(j).getDistance();
				
				if(cost < d[graph.get(now).get(j).getIndex()]) {
					d[graph.get(now).get(j).getIndex()] = cost;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n+1; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(start);
		
		for(int i=1; i<n+1; i++) {
			if(d[i] == INF) {
				System.out.println("INFINITY");
			} else {
				System.out.println(d[i]);
			}
		}
	}
}
