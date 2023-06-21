package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1966 {
	public static int max;
	public static Queue<Pair> q;

	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			q = new LinkedList<>(); 
			
			
			for(int j=0; j<m; j++) {
				q.add(new Pair(Integer.parseInt(st.nextToken()), j));
			}
			
			int cnt = 0;
			
			while(true) {
				max = Integer.MIN_VALUE;
				check(); //max 값 갱신
				
				int size = q.size();
				int rank = 0;
				int idx = 0;
				for(int j=0; j<size; j++) {
					Pair cur = q.poll();
					rank = cur.num;
					idx = cur.idx;
					
					if(rank == max) {//제일 높은 우선순위라면
						cnt++;
						break;
					} else {
						q.add(new Pair(rank, idx));
					}
				}
				if(idx == k) {
					break;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
		
	}
	
	public static class Pair {
		int num;
		int idx;
		
		public Pair(int num, int idx) {
			this.num = num;
			this.idx = idx;
		}
	}
	
	public static void check() {//max값 갱신
		int size = q.size();
		
		for(int i=0; i<size; i++) {
			
			Pair cur = q.poll();
			int num = cur.num;
			int idx = cur.idx;
			
			max = Math.max(max, num);
			
			q.add(new Pair(num, idx));
		}
	}

}
