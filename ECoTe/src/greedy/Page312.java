package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Page312 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int sum = str.charAt(0) -'0';
		
		for(int i=1; i<str.length(); i++) {
			
			int num = str.charAt(i) - '0';
			if(sum <= 1 || num <= 1) {
				sum += num;
			} else {
				sum *= num;
			}
		}
		
		System.out.println(sum);

	}

}
