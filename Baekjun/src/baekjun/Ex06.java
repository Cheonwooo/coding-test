package baekjun;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			sum+=i+1;
		}
		
		System.out.println(sum);
	}

}
