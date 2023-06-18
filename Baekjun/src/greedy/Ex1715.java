package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}

		if(n==1) {
			System.out.println(0);
		} else {
			long plus = pq.poll() + pq.poll();
			long sum = plus;
			pq.add(plus);
			int size = pq.size();
			
			while(size!=1) {
				
				plus = pq.poll() + pq.poll();
				sum += plus;
				
				pq.add(plus);
				size--;
			}

			System.out.println(sum);
			
		}
		
	}

}
