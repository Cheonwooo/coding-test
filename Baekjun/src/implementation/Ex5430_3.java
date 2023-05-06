package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex5430_3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			boolean check = false;
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine().replaceAll("[^0-9]", ".");
			
			Deque<Integer> dq = new ArrayDeque<Integer>();
			
			if(n==0) {
				if(func.contains("D")) {
					sb.append("error").append("\n");
					continue;
				} else {
					sb.append("[]").append("\n");
					continue;
				}
			} else {//n이 0이 아니라면
				String[] num = str.substring(1, str.length()-1).split("\\.");
				
				for(String s : num) {
					dq.offer(Integer.parseInt(s));
				}
				
				boolean isRight = true;
				for(int j=0; j<func.length(); j++) {
					if(func.charAt(j)=='R') {
						isRight = !isRight;
					} else {//D라면
						if(dq.size()==0) {
							sb.append("error").append("\n");
							check=true;
							break;
						}
						if(!isRight) {//R이 홀수번 나왔다면 한번만 reverse
							dq.pollLast();
						} else {
							dq.pollFirst();
						}
					}
				}
				if(dq.size()==0) {
					if(check) continue;
					else {
						sb.append("[]").append("\n");
						continue;
					}
				}
				
				sb.append("[");
				if(!isRight) {
					sb.append(dq.pollLast());
					while(!dq.isEmpty()) {
						sb.append(",").append(dq.pollLast());
					}
					sb.append("]").append("\n");
				} else {
					sb.append(dq.pollFirst());
					while(!dq.isEmpty()){
						sb.append(",").append(dq.pollFirst());
					}
					sb.append("]").append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
