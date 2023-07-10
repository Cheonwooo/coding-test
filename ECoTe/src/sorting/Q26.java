package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q26 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for(int i=0; i<n; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long sum = 0;
		long pre = 0;
		while(pq.size()!=1) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			
			pre = num1 + num2;
			sum += pre;
			pq.add(pre);
		}

		System.out.println(sum);
	}

}
