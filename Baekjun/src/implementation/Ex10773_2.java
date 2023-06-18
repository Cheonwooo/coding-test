package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex10773_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x==0) {
				s.pop();
			} else {
				s.push(x);
			}
		}
		
		int sum = 0;
		
		for(int v : s) {
			sum += v;
		}
		
		System.out.println(sum);
		
	}

}
