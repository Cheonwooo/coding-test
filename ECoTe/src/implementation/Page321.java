package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Page321 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[2];
		
		int len = (int)(Math.log10(n)+1)/2;//정수 n의 길이/2
		
		arr[0] = n/(int)(Math.pow(10, len));
		arr[1] = n%(int)(Math.pow(10, len));
		
		int sum;
		int temp;
		for(int i=0; i<2; i++) {
			sum = 0;
			for(int j=0; j<len; j++) {
				sum+=arr[i]%10;
				arr[i]/=10;
			}
			arr[i] = sum;
		}
		
		if(arr[0] == arr[1]) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
		
	}

}
