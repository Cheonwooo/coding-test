package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex11399 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		arr[0] = pq.poll();
		int sum = arr[0];
		for(int i=1; i<n; i++) {
			arr[i] = arr[i-1]+pq.poll();
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
