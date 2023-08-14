package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1783_answer {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		if(n==1) answer = 1;
		if(n==2) answer = Math.min((m+1)/2, 4);
		if(n>=3) {
			if(m<7) {
				answer = Math.min(m, 4);
			} else {
				answer = m-2;
			}
		}
		System.out.println(answer);
	}

}
