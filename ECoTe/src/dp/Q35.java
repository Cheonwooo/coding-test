package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q35 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[1001];
		
		d[1] = 1;
		int num = 2;
		int idx = 2;
		while(idx!=n+1) {
			int pf = num;
			
			while(pf%2==0) {
				pf /= 2;
			}
			while(pf%3==0) {
				pf /= 3;
			}
			while(pf%5==0) {
				pf /= 5;
			}
			if(pf!=1) {
				num++;
			} else {//pf==1
				d[idx] = num;
				num++;
				idx++;
			}
		}
		System.out.println(d[n]);
	}

}
