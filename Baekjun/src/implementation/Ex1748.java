package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1748 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[9];
		int[] part = new int[9];
		
		int len = (int)Math.log10(n);//10이면 1, 100이면 2

		for(int i=0; i<=len; i++) {
			arr[i] = 9*(int)(Math.pow(10, i))*(i+1);
			part[i] = 9*(int)(Math.pow(10, i));
		}
		
		if(len == 0) {
			System.out.println(n);
		} else {
			int sum = 0;
			int partSum = 0;
			for(int i=0; i<=len; i++) {
				
				if(i == len) {
					sum += (n-partSum)*(i+1);
				} else {
					partSum += part[i];
					sum += arr[i];
				}
			}
			System.out.println(sum);
		}
	}
}
