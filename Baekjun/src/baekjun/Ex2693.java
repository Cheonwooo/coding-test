package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2693 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());//내림차순 정렬
			
			for(int j=0; j<10; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			int idx = 3;
			while(true) {
				pq.poll();
				idx--;
				if(idx==1) {
					System.out.println(pq.poll());
					break;
				}
			}
		}
	}

}
