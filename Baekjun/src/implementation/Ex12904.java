package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12904 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String[] T = br.readLine().split("");
		
		while(T.length!=S.length()) {
			String sum = "";
			if(T[T.length-1].equals("A")) {
				T[T.length-1]="";
				
				for(int i=0; i<T.length; i++) {
					sum += T[i];
				}
			} else if(T[T.length-1].equals("B")) {
				T[T.length-1]="";
				
				for(int i=T.length-1; i>=0; i--) {
					sum += T[i];
				}
			}
			
			T = sum.split("");
		}
		
		String answer = "";
		for(int i=0; i<T.length; i++) {
			answer += T[i];
		}
		
		if(answer.equals(S)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
		
	}
	
}
