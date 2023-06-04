package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(arr, k));
	}
	
	public static int solution(int[] scoville, int k) {
		int answer = 0;
		
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for(int i=0; i<scoville.length; i++) {
			pq.add((long)scoville[i]);
		}
		
		while(pq.peek()<k) {
			long sum = pq.poll() + pq.poll()*2;
			pq.add(sum);
			answer++;
			
			if(pq.peek()<k && pq.size()==1) {
				answer = -1;
				break;
			}
		}
		
		return answer;
	}
}
