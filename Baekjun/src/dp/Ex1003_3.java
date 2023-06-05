package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1003_3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			int[][] d = new int[41][2];
			
			
			d[0][0] = 1;
			d[0][1] = 0;
			d[1][0] = 0;
			d[1][1] = 1;
			
			for(int j=2; j<num+1; j++) {
				d[j][0] = d[j-1][0] + d[j-2][0];
				d[j][1] = d[j-1][1] + d[j-2][1];
			}
			sb.append(d[num][0]).append(" ").append(d[num][1]).append("\n");
		}
		System.out.println(sb);
	}
	

}
