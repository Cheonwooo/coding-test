package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ex10866 {
	public static Deque<Integer> dq = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			if(str.length == 1) {
				deque(str[0], 0);
			} else {
				deque(str[0], Integer.parseInt(str[1]));
			}
		}
		System.out.println(sb);
	}
	
	public static void deque(String str, int n) {
		if(n==0) {
			if(str.equals("pop_front")) {
				if(dq.size()==0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.pollFirst()).append("\n");
				}
			} else if(str.equals("pop_back")) {
				if(dq.size()==0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.pollLast()).append("\n");
				}
			} else if(str.equals("size")) {
				sb.append(dq.size()).append("\n");
			} else if(str.equals("empty")) {
				if(dq.size()==0) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if(str.equals("front")) {
				if(dq.size()==0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.peekFirst()).append("\n");
				}
			} else if(str.equals("back")) {
				if(dq.size()==0) {
					sb.append(-1).append("\n");
				} else {
					sb.append(dq.peekLast()).append("\n");
				}
			}
		} else {
			if(str.equals("push_front")) {
				dq.offerFirst(n);
			} else if(str.equals("push_back")) {
				dq.offerLast(n);
			}
		}
	}

}
