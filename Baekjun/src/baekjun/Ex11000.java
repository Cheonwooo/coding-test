package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Ex11000 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] = Integer.parseInt(st.nextToken());//시작시간
			arr[i][1] = Integer.parseInt(st.nextToken());//종료시간
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i][0]);
			System.out.println(" " + arr[i][1]);
		}
		
		pq.offer(arr[0][1]);
		
		for(int i=1; i<n; i++) {
			if(pq.peek() <= arr[i][0]) {
				pq.poll();
			}
			pq.offer(arr[i][1]);
		}
		
		System.out.println(pq.size());
	}

}

