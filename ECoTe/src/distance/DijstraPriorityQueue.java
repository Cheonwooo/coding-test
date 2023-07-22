package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */

public class DijstraPriorityQueue {
	
	public static final int INF = (int) 1e9;
	public static int n, m, start;
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[100001];

	public static class Node implements Comparable<Node>{
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
		
		public int compareTo(Node other) {
			if(this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
	}
	
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.getDistance();
			int now = node.getIndex();
			
			if(d[now] < dist) continue;
			
			for(int i=0; i<graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).getDistance();
				
				if(cost < d[graph.get(now).get(i).getIndex()]) {
					d[graph.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
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
