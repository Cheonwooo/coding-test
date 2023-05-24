package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//첫번째 생각 : 이차배열 사용
//
public class Ex4 {
	public static int max;
	public static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int l = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		solution(arr, l);
	}
	
	public static void solution(int[] properties, int location) {
		
		
		for(int i=0; i<properties.length; i++) {
			q.add(properties[i]);
		}
		check();
		int idx = location;
		int cnt = 0;
		while(true) {
			int x = q.poll();
			if(x!=max) {
				q.add(x);
				idx--;
				if(idx<0) {
					idx = q.size()-1;
				}
			} else if(x==max) {
				if(idx==0) {
					cnt++;
					break;
				} else {
					idx--;
					cnt++;
					if(idx<0) {
						idx = q.size()-1;
					}
					check();
				}
			}
		}
		System.out.println(cnt);
		
	}
	
	public static void check() {
		max = Integer.MIN_VALUE;
		for(int i=0; i<q.size(); i++) {
			int x = q.poll();
			max = Math.max(max, x);
			q.add(x);
		}
	}

}
