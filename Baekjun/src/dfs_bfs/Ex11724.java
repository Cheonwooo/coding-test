package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex11724 {
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1];
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			if(!visited[i]) {//i번째 노드에 방문하지 않았다면
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int nx = q.poll();
			
			for(int i=0; i<list.get(nx).size(); i++) {
				int y = list.get(nx).get(i);
				if(!visited[y]) {
					visited[y] = true;
					q.offer(y);
				}
			}
		}
	}
}
