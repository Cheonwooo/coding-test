package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Ex11286 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) ->{
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1==abs2) {
				return o1-o2;
			} else if(abs1>abs2){
				return abs1-abs2;
			} else {
				return -1;
			}
		});//¿ø¹è¿­
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty()) sb.append("0").append("\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(x);
			}
		}
		System.out.println(sb);
	}

}
