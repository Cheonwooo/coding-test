package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Lv2ex3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = {9, 1, 5, 3, 6, 2};
		
		System.out.println(Arrays.toString(solution(arr)));
		
	}

	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for(int i=1; i<numbers.length; i++) {
			while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {//뒷 큰수가 존재한다면
				answer[stack.pop()] = numbers[i];
			}
			stack.push(i);
			
		}
		
		while(!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}
		
		return answer;
	}
}
