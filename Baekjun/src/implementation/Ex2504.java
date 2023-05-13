package implementation;

//9, 16, 21, 28, 32, 39, 43
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex2504 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int answer = 0;
		int temp = 1;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.push(str.charAt(i));
				temp *= 2;
				
			} else if(str.charAt(i)=='[') {
				stack.push(str.charAt(i));
				temp *= 3;
				
			} else if(str.charAt(i)==')') {
				if( stack.isEmpty() || stack.peek()!='(') {
					answer = 0;
					break;
				} else if(str.charAt(i-1) == '(') {
					answer += temp;
				}
				stack.pop();
				temp /= 2;
			} else if(str.charAt(i)==']') {
				if(stack.isEmpty() || stack.peek()!='[') {
					answer = 0;
					break;
				} else if(str.charAt(i-1) == '[') {
					answer += temp;
				}
				stack.pop();
				temp /= 3;
			}
		}
		
		if(!stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}
}
