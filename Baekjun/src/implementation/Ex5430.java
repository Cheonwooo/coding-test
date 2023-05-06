package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex5430 {
	public static int m;
	public static Stack<Integer> stack1, stack2;
	public static int[] answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			String func = br.readLine();
			m = Integer.parseInt(br.readLine());
			boolean check = false;
			
			if(m==0) {
				
				String str = br.readLine().replaceAll("[^0-9]", "");
				
				if(func.contains("D")) {
					sb.append("error").append("\n");
					continue;
				} else {
					sb.append("[]").append("\n");
					continue;
				}
			} else {
				
			}
			
			String str = br.readLine().replaceAll("[^0-9]", ".");
			String[] str2 = str.substring(1,str.length()-1).split("\\.");
			stack1 = new Stack<Integer>();
			
			for(int j=0; j<str2.length; j++) {
				stack1.push(Integer.parseInt(str2[j]));
			}
			
			answer = new int[stack1.size()];
			
			for(int j=0; j<func.length(); j++) {
				if(m==0) {
					sb.append("error").append("\n");
					check = true;
					break;
				}
				function(func.charAt(j));
			}
			if(m==0) {
				if(check) continue;
				else {
					sb.append("[]").append("\n");
					continue;
				}
			}
			
			for(int j=0; j<answer.length; j++) {
				answer[answer.length-1-j] = stack1.peek();
				stack1.pop();
			}
			sb.append("[");
			for(int j=0; j<answer.length-1; j++) {
				sb.append(answer[j]).append(",");
			}
			sb.append(answer[answer.length-1]).append("]").append("\n");
			
		}
		System.out.println(sb);
	}
	
	public static void function(char c) {

		stack2 = new Stack<Integer>();
		
		if(c=='R') {
			answer = new int[stack1.size()];
			int idx = 0;
			while(!stack1.isEmpty()) {
				answer[idx] = stack1.peek();
				stack2.push(stack1.peek());
				stack1.pop();
				idx++;
			}
			
			for(int v : answer) {
				stack1.push(v);
			}
		} else if(c=='D') {
			if(stack1.size() == 1) {
				stack1.pop();
				m--;
			} else {
				while(stack1.size()!=1) {
					stack2.push(stack1.peek());
					stack1.pop();
				}
				
				stack1.pop();
				
				answer = new int[stack2.size()];
				
				int idx = 0;
				while(!stack2.isEmpty()) {
					stack1.push(stack2.peek());
					answer[idx] = stack2.peek();
					stack2.pop();
				}
				m--;
			}
		}
	}
}
