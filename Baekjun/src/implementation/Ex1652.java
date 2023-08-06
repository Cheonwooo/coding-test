package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1652 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		boolean[][] arr = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split("");
			for(int j=0; j<n; j++) {
				if(str[j].equals(".")) {
					arr[i][j]=true;
				}
			}
		}
		
		int col = 0;
		int row = 0;
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			boolean check = false;
			for(int j=0; j<n; j++) {
				if(arr[i][j]) {
					cnt++;
				}
				else {
					cnt=0;
					check = false;
				}
				if(cnt>=2 && !check) {
					row++;
					check = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			boolean check = false;
			for(int j=0; j<n; j++) {
				if(arr[j][i]) {
					cnt++;
				}
				else {
					cnt=0;
					check = false;
				}
				if(cnt>=2 && !check) {
					col++;
					check = true;
				}
			}
		}
		
		System.out.println(row + " " + col);
	}

}

