package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q6 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(arr, k));
	}
	
	public static int solution(int[] food_times, long k) {
		int answer = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		long sum = 0;
		for(int i=0; i<food_times.length; i++) {
			pq.offer(new Pair(i+1, food_times[i]));
			sum += food_times[i];
		}
		
		if(sum<=k) {
			answer = -1;
		} else {
			sum = 0;//지금까지 걸린 시간
			long len = food_times.length;//남은 음식
			long pre = 0;//직전 음식의 food_time
			
			while(sum+(pq.peek().food_time - pre) * len <= k) {
				int now = pq.poll().food_time;
				sum += (now - pre) * len;
				len -= 1;
				pre = now;
			}
			
			ArrayList<Pair> result = new ArrayList<Pair>();
			while(!pq.isEmpty()) {
				result.add(pq.poll());
			}
			
			Collections.sort(result, new Comparator<Pair>() {
				public int compare(Pair o1, Pair o2) {
					return o1.idx - o2.idx;
				}
			});
			
			answer = result.get((int)((k-sum)%len)).idx;
		}
		
		return answer;
	}
	
	public static class Pair implements Comparable<Pair>{
		
		int idx;
		int food_time;
		
		public Pair(int idx, int food_time) {
			
			this.idx = idx;
			this.food_time = food_time;
			
		}
		
		public int compareTo(Pair other) {
			return Integer.compare(this.food_time, other.food_time);
		}
	}
}
