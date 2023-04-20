package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1697 {
	public static int n, k;
	public static int[] check = new int[100001];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n==k) {
			System.out.println(0);
		} else {
			bfs(n);
		}
		
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		check[x] = 1;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			for(int i=0; i<3; i++) {
				int next;
				
				if(i==0) {
					next = num-1;
				} else if(i==1) {
					next = num + 1;
				} else {
					next = num*2;
				}
				if(next==k) {
					System.out.println(check[num]);
					return;
				}
				
				if(next >=0 && next<check.length&&check[next] ==0 ) {
					q.add(next);
					check[next] = check[num] + 1;
				}
			}
		}
	}

}
