package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
 */

public class TopologySort {
	
	public static int v, e;
	public static int[] indegree = new int[100001];
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void topologySort() {
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1 ;i<v+1; i++) {
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			
			for(int i=0; i<list.get(now).size(); i++) {
				indegree[list.get(now).get(i)] -= 1;
				
				if(indegree[list.get(now).get(i)] == 0) {
					q.offer(list.get(now).get(i));
				}
			}
		}
		
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<v+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			
			indegree[b] += 1;
		}
		
		topologySort();
	}

}
