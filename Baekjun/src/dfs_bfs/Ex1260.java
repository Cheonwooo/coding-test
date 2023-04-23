package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

	/*
	 * dfs´Â Àç±Í bfs´Â queue 
	 */
public class Ex1260 {
	public static boolean[] check;
	public static int n;
	public static ArrayList<ArrayList<Integer>> dfs_list = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> bfs_list = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int[][] arr = new int[m*2][2];
		
		
		for(int i=0; i<n+1; i++) {
			dfs_list.add(new ArrayList<Integer>());
			bfs_list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
			arr[arr.length-i-1][0] = y;
			arr[arr.length-i-1][1] = x;
		}
		
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		for(int i=0; i<arr.length; i++) {
			dfs_list.get(arr[i][0]).add(arr[i][1]);
			bfs_list.get(arr[i][0]).add(arr[i][1]);
		}
		
		
		check = new boolean[n+1];
		System.out.print(v + " ");
		dfs(v);
		System.out.println();
		
		check = new boolean[n+1];
		System.out.print(v + " ");
		bfs(v);
	}
	
	public static void dfs(int start) {
		
		check[start] = true;
		
		for(int i=0; i<dfs_list.get(start).size(); i++) {
			int y = dfs_list.get(start).get(i);
			
			if(!check[y]) {
				System.out.print(y + " ");
				dfs(y);
			}
		}
	}
	
	public static void bfs(int start) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i=0; i<bfs_list.get(num).size(); i++) {
				int y = bfs_list.get(num).get(i);
				
				if(!check[y]) {
					System.out.print(y + " ");
					check[y] = true;
					q.add(y);
				}
			}
		}
	}

}
