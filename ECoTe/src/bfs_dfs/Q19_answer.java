package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19_answer {
	public static int n, add, sub, mul, div;
	public static long max, min;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		add = Integer.parseInt(st.nextToken());
		sub = Integer.parseInt(st.nextToken());
		mul = Integer.parseInt(st.nextToken());
		div = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(1, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int i, int num) {
		System.out.println(num);
		if(i==n) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		} else {
			if(add>0) {
				add-=1;
				dfs(i+1, num + arr[i]);
				add+=1;
			}
			if(sub>0) {
				sub-=1;
				dfs(i+1, num - arr[i]);
				sub+=1;
			}
			if(mul>0) {
				mul-=1;
				dfs(i+1, num * arr[i]);
				mul+=1;
			}
			if(div>0) {
				div-=1;
				dfs(i+1, num / arr[i]);
				div+=1;
			}
		}
	}
}
