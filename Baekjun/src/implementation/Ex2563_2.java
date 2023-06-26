package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2563_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[101][101];
		
		int sum =0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<x+10; j++) {
				for(int k=y; k<y+10; k++) {
					if(!arr[j][k]) {
						arr[j][k] = true;
						sum++;
					}
				}
			}
			
		}
		
		System.out.println(sum);
		
	}

}
