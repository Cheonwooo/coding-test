package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10872 {
	
	public static int fact(int n) {
		int num = 1;
		for(int i=1; i<n+1; i++) {
			num *= i;
		}
		return num;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	
		
		System.out.println(fact(N));
	}

}
