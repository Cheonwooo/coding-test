package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Page339 {
	
	public static int n, m, k, x;
	public static ArrayList<ArrayList<Integer>> city = new ArrayList<ArrayList<Integer>>();
	public static int[] visited = new int[300001];

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());//도시 개수
		m = Integer.parseInt(st.nextToken());//도로 개수
		k = Integer.parseInt(st.nextToken());//거리 정보
		x = Integer.parseInt(st.nextToken());//출발 도시
		
		for(int i=0; i<n+1; i++) {
			city.add(new ArrayList<Integer>());
			visited[i] = -1;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			city.get(a).add(b);
		}
		
		//bfs
		visited[x] = 0;//출발 노드는 0
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<city.get(now).size(); i++) {
				int next = city.get(now).get(i);
				
				if(visited[next]==-1) {//방문하지 않았다면
					visited[next] = visited[now]+1;
					q.offer(next);
				}
			}
		}
		
		boolean check = false;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			if(visited[i]==k) {
				sb.append(i).append("\n");
				check = true;
			}
		}
		
		if(!check) sb.append(-1);
		
		System.out.println(sb);
	}
	
	

}
