package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int num = n;
		
		int cnt = 0;
		while(true) {
			cnt++;
			if(num<10) {
				num = num*10 + num;
			} else {
				int x = num/10;
				int y = num%10;
				
				int new_num = x+y;
				
				num = y*10 + new_num%10;
			}
			
			if(num==n) {
				break;
			}
		}
		System.out.println(cnt);
	}

}
