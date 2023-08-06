package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2503 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		boolean[] check = new boolean[1000];
		
		for(int i=123; i<1000; i++) {
			String str = Integer.toString(i);
			
			if(str.charAt(0)=='0' || str.charAt(1)=='0' || str.charAt(2)=='0') continue;
			if(str.charAt(0)==str.charAt(1) || str.charAt(1)==str.charAt(2) || str.charAt(0)==str.charAt(2)) continue;
			check[i] = true;
		}
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			
			for(int ans=123; ans<1000; ans++) {
				if(check[ans]) {
					int ns = 0;
					int nb = 0;
					
					for(int a=0; a<3; a++) {
						char num_split = Integer.toString(num).charAt(a);
						
						for(int b=0; b<3; b++) {
							char ans_split = Integer.toString(ans).charAt(b);
							
							if(num_split == ans_split && a == b) ns++;
							if(num_split == ans_split && a != b) nb++;
						}
					}
					
					if(ns == strike && nb == ball) check[ans] = true;
					else check[ans] = false;
				}
			}
		}
		
		int cnt = 0;
		for(int i=123; i<1000; i++) {
			if(check[i]) cnt++;
		}
		System.out.println(cnt);
	
	}

}
