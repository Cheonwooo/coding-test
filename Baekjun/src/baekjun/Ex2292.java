package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2292 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long num = Long.parseLong(br.readLine());
		long sum = 1;
		int count = 1;
		
		
		if(num == 1) {
			System.out.println(1);
		}
		else {
			while(true) {
				if(num>sum && num<=sum+(6*count)) {
					count++;
					break;
				} else {
					sum = sum + (6*count);
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
