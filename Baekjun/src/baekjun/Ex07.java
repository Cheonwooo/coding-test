package baekjun;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int ac = sc.nextInt();
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		
		for(int i=0; i<num; i++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[i] = a*b;
		}
		
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		
		if(sum==ac) System.out.println("Yes");
		else System.out.println("No");
	}

}
