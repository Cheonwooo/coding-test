package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");		
		int[] arr = new int[str.length];
		
		System.out.println(str[1]);
		for(int i=0; i<str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		
		int sum = 0;
		for(int i=0; i<arr.length-1;i++) {
			if(arr[i]==0) {
				sum += arr[i+1];
			} else {
				sum *= arr[i+1];
			}
		}
		System.out.println(sum);
		
	}

}
