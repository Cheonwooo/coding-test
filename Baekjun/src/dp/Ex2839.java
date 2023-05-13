package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2839 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n+1];
		
		if(n >= 3) {
			d[3] = 1;
		}
		if(n >= 5) {
			d[5] = 1;
		}
		
		for(int i=6 ; i<d.length; i++) {
			if(i%5==0) {
				d[i] = d[i-5] + 1;
			} else if(i%3==0) {
				d[i] = d[i-3] + 1;
			} else {
				if(d[i-3] !=0 && d[i-5]!=0) {
					d[i] = Math.min(d[i-3], d[i-5]) + 1;
				}
			}
		}
		
		if(d[n] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(d[n]);
		}
	}

}
