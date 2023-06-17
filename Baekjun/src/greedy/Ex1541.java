package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
		
		int answer = Integer.MAX_VALUE;
		while(minus.hasMoreTokens()) {
			
			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
			
			int sum = 0;
			
			while(plus.hasMoreTokens()) {
				sum += Integer.parseInt(plus.nextToken());
			}
			
			if(answer == Integer.MAX_VALUE) {
				answer = sum;
			} else {
				answer -= sum;
			}	
		}
		
		System.out.println(answer);
	}

}
