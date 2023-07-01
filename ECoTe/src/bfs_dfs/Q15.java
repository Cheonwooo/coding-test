package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q15 {
	public static int n, m, k, x;
	public static int[] visited = new int[300001];
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<n+1; i++) {//1~n까지 도시 개수
			list.add(new ArrayList<Integer>());
			visited[i] = -1;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
		}
		visited[x] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				
				if(visited[next]==-1) {
					visited[next] = visited[now] + 1;
					q.offer(next);
				}
			}
		}
		boolean check = false;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n+1; i++) {
			if(visited[i]==k) {
				sb.append(i).append("\n");
				check = true;
			}
		}
		if(!check) sb.append(-1);
		
		System.out.println(sb);
		
		
	}
}
