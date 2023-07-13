package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Page223 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[1001];
		
		d[1] = 1;
		d[2] = 3;
		
		for(int i=3; i<n+1; i++) {
			d[i] = d[i-1] + d[i-2]*2;
		}
		System.out.println(d[n]%796796);
	}

}
