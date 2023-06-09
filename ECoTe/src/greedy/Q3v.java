package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3v {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String num = br.readLine();
		String num1 = num.replaceAll("[^1]", "-");
		String num2 = num.replaceAll("[^0]", "-");
		
		
		int cnt = 0;
		if(num.charAt(0)=='1') {
			for(int i=0; i<num.length()-1; i++) {
				if(num1.charAt(i)=='1' && num1.charAt(i+1)=='-') {
					cnt++;
				}
			}
		} else {
			for(int i=0; i<num.length()-1; i++) {
				if(num1.charAt(i)=='-' && num1.charAt(i+1)=='1') {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}

}
