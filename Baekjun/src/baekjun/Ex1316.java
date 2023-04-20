package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = n;
		
		for(int i=0; i<n; i++) {
			
			String str = br.readLine();
			
			if(str.length()>2) { //단어의 길이가 2보다 클 경우
				loop:
				for(int j=0; j<str.length()-2; j++) {
					for(int k=j+2; k<str.length(); k++) {
						if(str.charAt(j)!=str.charAt(j+1) && str.charAt(j)==str.charAt(k)) {
							count--;
							break loop;
						}
					}
				}
			}
		}
		System.out.println(count);	
	}
}
