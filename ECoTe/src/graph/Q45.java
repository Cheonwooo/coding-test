package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q45 {
	public static int[] indegree = new int[501];
	public static boolean[][] graph = new boolean[501][501];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			Arrays.fill(indegree, 0);
			for(int i=0; i<501; i++) {
				Arrays.fill(graph[i], false);
			}
			
			int n = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					graph[list.get(i)][list.get(j)] = true;
					indegree[list.get(j)] += 1;
				}
			}
			
			int m = Integer.parseInt(br.readLine());
			if(m==0) {
				for(int i=0; i<list.size(); i++) {
					System.out.print(list.get(i) + " ");
				}
				System.out.println();
			} else {
				for(int i=0; i<m; i++) {
					st = new StringTokenizer(br.readLine());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					
					if(graph[a][b]) {
						graph[a][b] = false;
						graph[b][a] = true;
						indegree[a] += 1;
						indegree[b] -= 1;
					} else {
						graph[a][b] = true;
						graph[b][a] = false;
						indegree[a] -= 1;
						indegree[b] += 1;
					}
				}
				
				ArrayList<Integer> result = new ArrayList<Integer>();
				Queue<Integer> q = new LinkedList<>();
				
				for(int i=1; i<list.size()+1; i++) {
					if(indegree[i] == 0) {
						q.offer(i);
					}
				}
				
				boolean certain = true;//위상 정렬 결과가 하나인지
				boolean cycle = false;//그래프 내 사이클이 존재하는지
				
				//노드의 개수만큼
				for(int i=0; i<n; i++) {
					if(q.size()==0) {
						cycle = true;
						break;
					}
					
					if(q.size()>=2) {
						certain = false;
						break;
					}
					
					int now = q.poll();
					result.add(now);
					
					for(int j=1; j<=n; j++) {
						if(graph[now][j]) {
							indegree[j] -= 1;
							
							if(indegree[j]==0) {
								q.offer(j);
							}
						}
					}
				}
				
				if(cycle) {
					System.out.println("IMPOSSIBLE");
				} else if(!certain) {
					System.out.println("?");
				} else {
					for(int i=0; i<result.size(); i++) {
						System.out.print(result.get(i) + " ");
					}
					System.out.println();
				}
			}
			
		}
	}
}
