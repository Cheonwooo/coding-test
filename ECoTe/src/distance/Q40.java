package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import bfs_dfs.Q19_answer;


/*
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
public class Q40 {
	public static int INF = (int)1e9;
	public static int n, m;
	public static ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
	public static int[] d = new int[20001];
	public static PriorityQueue<Integer> answer = new PriorityQueue<>();
	
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

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<m; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, 1));
			list.get(b).add(new Node(a, 1));
		}
		
		Arrays.fill(d, INF);
		
		dijkstra(1);

		int max = Integer.MIN_VALUE;
		int cnt = 1;
		for(int i=2; i<n+1; i++) {
			if(max < d[i]) {
				answer = new PriorityQueue<>();
				answer.offer(i);
				max = d[i];
				cnt=1;
			} else if(max == d[i]) {
				answer.offer(i);
				cnt++;
			}
		}
		System.out.println(answer.poll() + " " + max + " " + cnt);
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
			
			for(int i=0; i<list.get(now).size(); i++) {
				int cost = d[now] + list.get(now).get(i).getDistance();
				if(cost < d[list.get(now).get(i).getIndex()]) {
					d[list.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(list.get(now).get(i).getIndex(), cost));
				}
			}
		}
	}
}
