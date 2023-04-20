package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Ex1927 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x!=0) {//x가 0이 아니라면 추가
				pq.add(x);
			} else { //x가 0이라면 출력후 제거
				if(pq.size()==0) {
					System.out.println("0");
				} else {
					System.out.println(pq.poll());
				}
			}
		}
	}
}
