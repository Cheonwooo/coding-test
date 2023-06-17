package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1026_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		int[] b = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			pq.add(b[i]);
		}
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum += a[i]*pq.poll();
		}
		
		System.out.println(sum);
	}

}
