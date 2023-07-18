package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex2161 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<n+1; i++) {
			q.offer(i);
		}
		
		while(q.size()!=1) {
			sb.append(q.poll()).append(" ");
			q.offer(q.poll());
		}
		sb.append(q.poll());
		
		System.out.println(sb);
	}

}
