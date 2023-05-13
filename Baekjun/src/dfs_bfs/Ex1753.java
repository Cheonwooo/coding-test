package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1753 {
	public static int vert, sum, min;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static int[][] arr;
	public static StringBuilder sb = new StringBuilder();
	public static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vert = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		visited = new boolean[vert+1];
		
		for(int i=0; i<vert+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		arr = new int[vert+1][vert+1];
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
			if(arr[u][v]==0) {
				arr[u][v] = w;
			} else {
				arr[u][v] = Math.min(arr[u][v], w);
			}
		}
		
		
	}
	
	public static void function(int start) {
		for(int i=1; i<vert+1; i++) {
			
		}
	}
}
