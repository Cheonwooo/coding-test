package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//작업 수행이 없을 때 먼저 요청이 들어온 작업부터 처리
public class Ex2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(arr));
	}
	
	public static int solution(int[][] jobs) {
		
		Arrays.sort(jobs, new Comparator<int[]>() {//jobs[0] 기준 오름차순
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int idx = 0;
		int sum = 0;
		int end = 0;
		int count = 0;
		
		while(count < jobs.length) {
			
			while(idx < jobs.length && jobs[idx][0] <= end) {
				pq.add(jobs[idx++]);
			}
			
			if(pq.isEmpty()) {
				end = jobs[idx][0];
			} else {
				int[] now = pq.poll();
				sum += now[1] + end - now[0];
				end += now[1];
				count++;
			}
		}
		
		return sum/jobs.length;
	}
}
