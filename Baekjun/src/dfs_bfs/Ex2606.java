package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2606 {
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static boolean[] visited;
	public static int cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		visited = new boolean[n+1];
		
		StringTokenizer st;
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
		bfs(1);
		
		System.out.println(cnt);
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		cnt = -1;
		
		while(!q.isEmpty()) {
			int nx = q.poll();
			for(int i=0; i<list.get(nx).size(); i++) {
				int y = list.get(nx).get(i);
				if(!visited[y]) {
					visited[y] = true;
					cnt++;
					q.offer(y);
				}
			}
		}
	}

}
