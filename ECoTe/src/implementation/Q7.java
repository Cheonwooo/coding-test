package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		String[] str = String.valueOf(num).split("");
		
		int a = 0;
		int b = 0;
		
		for(int i=0; i<str.length; i++) {
			if(i<str.length/2) {
				a += Integer.parseInt(str[i]);
			} else {
				b += Integer.parseInt(str[i]);
			}
		}
		
		if(a == b) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
	}

}
