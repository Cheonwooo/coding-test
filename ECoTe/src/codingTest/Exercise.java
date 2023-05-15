package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise {
	public static int n, m;
	public static ArrayList<ArrayList<Integer>> list;
	public static int max;
	public static boolean[] visited;

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<arr.length-1; j++) {
				for(int k=j+1; k<arr.length; k++) {
					int sum = arr[j] * arr[k];
					
					if(!check(sum)) {//단조증가수라면
						pq.add(sum);
					}
				}
			}	
			if(pq.size()==0) {
				sb.append("#").append(i+1).append(" ").append(-1).append("\n");
			} else {
				sb.append("#").append(i+1).append(" ").append(pq.poll()).append("\n");
			}
			
		}
		System.out.println(sb);
	}
	
	public static boolean check(int x) {
		String str = String.valueOf(x);
		int[] arr = new int[str.length()];
		boolean check = false;
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(str.charAt(i)-'0');
		}
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] > arr[i+1]) {
				check = true;
				break;
			}
		}
		return check;
	}
}
