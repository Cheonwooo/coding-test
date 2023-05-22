package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Lv1ex4 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		
		System.out.println(Arrays.toString(solution(array, commands)));
		
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int startIdx = commands[i][0];
			int endIdx = commands[i][1];
			int searchIdx = commands[i][2];
			
			int[] copyArray = Arrays.copyOfRange(array, startIdx-1, endIdx);
			Arrays.sort(copyArray);
			answer[i] = copyArray[searchIdx-1];
		}
		
		return answer;
	}

}
