package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex1158_2 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Queue<Integer> pq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			pq.add(i+1);
		}
		
		int cnt = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(!pq.isEmpty()) {
			if(cnt==k) {
				list.add(pq.poll());
				cnt = 1;
			} else {
				pq.add(pq.poll());
				cnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<");
		
		for(int i=0; i<list.size()-1; i++) {
			sb.append(list.get(i)).append(", ");
		}
		
		sb.append(list.get(list.size()-1)).append(">");
		
		System.out.println(sb);
	}
}
