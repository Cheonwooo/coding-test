package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q38 {
	public static int n, m;
	public static int[][] arr;
	public static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[501][501];
		int[] d = new int[501];
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);//list.get(1).get(0)=5
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<n+1; i++) {
			q.offer(i);
			int idx = i;
			while(!q.isEmpty()) {
				int start = q.poll();
				
				for(int j=0; j<list.get(start).size(); j++) {
					int std = list.get(start).get(j);
					if(arr[idx][std]==0) arr[idx][std]++;
					q.add(std);
				}
			}
		}
		
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				d[i] += arr[i][j] + arr[j][i];
			}
			if(d[i]==n-1) cnt++;
		}
		
		System.out.println(cnt);
	}

	public static void floyd(int start) {
		
	}
}
