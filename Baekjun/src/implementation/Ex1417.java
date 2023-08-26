package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Ex1417 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		int first = 0;
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(i==0) {
				first = num;
			} else {
				q.offer(num);
			}
		}
		
		if(n==1) {
			System.out.println(0);
		} else {
			int cnt = 0;
			while(true) {
				int num = q.poll();
				
				if(first<=num) {
					cnt++;
					first++;
					num--;
					q.offer(num);
				} else if(first>num) {
					break;
				}
			}
			System.out.println(cnt);
		}
		
	}

}
