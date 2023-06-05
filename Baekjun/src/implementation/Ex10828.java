package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex10828 {
	public static Stack<Integer> s = new Stack<Integer>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			if(str.length == 2) {
				int x = Integer.parseInt(str[1]);
				s.push(x);
			} else {
				check(str[0]);
			}
		}
	}
	
	public static void check(String str) {
		if(str.equals("pop")) {
			
			if(s.size()==0) {
				
				System.out.println(-1);
				
			} else {
				
				System.out.println(s.peek());
				s.pop();
				
			}
		} else if(str.equals("size")) {
			
			System.out.println(s.size());
			
		} else if(str.equals("empty")) {
			
			if(s.size()==0) {
				
				System.out.println(1);
				
			} else {
				
				System.out.println(0);
			}
		} else if(str.equals("top")) {
			
			if(s.size()==0) {
				
				System.out.println(-1);
				
			} else {
				
				System.out.println(s.peek());
			}
		}
		return;
	}
}
