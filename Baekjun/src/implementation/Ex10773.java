package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex10773 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<k; i++) {
			int n = Integer.parseInt(br.readLine());
			
			if(n!=0) {
				stack.add(n);
			} else if(n==0) {
				stack.pop();
			}
		}
		
		int sum = 0;
		while(!stack.isEmpty()) {
			sum += stack.peek();
			stack.pop();
		}
		System.out.println(sum);
	}

}
