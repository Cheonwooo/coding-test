package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Page262 {
	public static final int INF = (int) 1e9;
	public static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	public static int n, m, c;
	public static int[] d = new int[30001];
	
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
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int now = node.getIndex();
			int dist = node.getDistance();
			
			for(int i=0; i<list.get(now).size(); i++) {
				int cost = d[now] + list.get(now).get(i).getDistance();
				
				if(cost < d[list.get(now).get(i).getIndex()]) {
					d[list.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(list.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			list.get(x).add(new Node(y, z));
//			list.get(y).add(new Node(x, z));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(c);
		
		int cnt = 0;
		int time = 0;
		
		for(int i=1; i<n+1; i++) {
			if(d[i]!=INF) {
				cnt++;
				time += d[i];
			}
		}
		System.out.println((cnt-1) + " " + time);
	}

}
