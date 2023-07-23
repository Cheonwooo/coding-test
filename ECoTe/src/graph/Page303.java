package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Page303 {
	public static int n, max;
	public static int[] time = new int[501];
	public static int[] indegree = new int[501];
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static int[] result = new int[501];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int idx = 0;
			while(true) {
				int x = Integer.parseInt(st.nextToken());
				if(idx==0) {
					time[i] = x;
					idx++;
				} else if(x==-1) {
					break;
				} else {
					indegree[i] += 1;
					list.get(x).add(i);
				}
			}
		}
		topologySort();
	}
	
	public static void topologySort() {
		for(int i=1; i<n+1; i++) {
			result[i] = time[i];
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<n+1; i++) {
			if(indegree[i]==0) {
				q.offer(i);
			}
		}
		max = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<list.get(now).size(); i++) {				
				result[list.get(now).get(i)] = Math.max(result[list.get(now).get(i)], time[list.get(now).get(i)] + result[now]);
				indegree[list.get(now).get(i)] -= 1;
				
				if(indegree[list.get(now).get(i)]==0) {
					q.offer(list.get(now).get(i));
				}
			}
		}
		for(int i=1; i<n+1; i++) {
			System.out.println(result[i]);
		}
	}

}
