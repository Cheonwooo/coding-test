package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1783 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int answer = 1;
		if(n==1 || m==1) {
			System.out.println(1);
		} else if(n==2 && m>=2 && m<=8) {
			answer += (m-1)/2;
			System.out.println(answer);
		} else if(n==2 && m>8) {
			System.out.println(4);
		} else if(n>2 && m>=2 && m<=3) {
			System.out.println(m);
		} else if(n>2 && m>3 && m<=6) {
			System.out.println(4);
		} else if(n>2 && m>6) {
			answer = 5;
			answer += m-7;
			System.out.println(answer);
		}
	}

}
