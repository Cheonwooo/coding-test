package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4673 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] arr = new boolean[20001];
		
		for(int i=1; i<10001; i++) {
			if(i<10) {
				int sum = 0;
				sum = i+i;
				arr[sum] = true;
			} else {
				int num = i;
				int sum = i;
				while(num>=10) {
					sum += num%10;
					num /= 10;
				}
				sum += num;
				arr[sum] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<10001; i++) {
			if(!arr[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}

}
