package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2775 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[15][15];
		
		int sum = 0;
		
		for(int i=1; i<15; i++) {
			arr[0][i] = i;
		}
		
		for(int j=1; j<15; j++) {
			sum = 0;
			for(int k=1; k<15; k++) {
				sum += arr[j-1][k];
				arr[j][k] = sum;
			}
		}
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(arr[k][n]);
		}
		
	}

}
