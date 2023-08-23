package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1769 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int cnt = 0;
		while(true) {
			long sum=0;
			if(str.length()==1) {
				break;
			}
			
			for(int i=0; i<str.length(); i++) {
				sum += str.charAt(i)-'0';
			}
			
			cnt++;

			str = String.valueOf(sum);
		}
		
		System.out.println(cnt);
		System.out.println((Integer.parseInt(str)%3==0) ? "YES" : "NO");
	}

}
