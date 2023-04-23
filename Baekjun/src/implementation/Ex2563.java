package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2563 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[101][101];//0~100, 0~100
		
		
		StringTokenizer st;
		int sum = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			
			for(int j=x; j<x+10; j++) {
				for(int l=y; l<y+10; l++) {
					if(!arr[j][l]) {
						arr[j][l] = true;
						sum++;
					}
				}
			}
		}

		System.out.println(sum);
	}

}
