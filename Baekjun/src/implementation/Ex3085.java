package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3085 {
	public static int n;
	public static char[][] arr;
	public static int answer = Integer.MIN_VALUE;
	public static int max = Integer.MIN_VALUE;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				char tmp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = tmp;
				
				check();
				
				tmp = arr[i][j];
				arr[i][j] = arr[i][j+1];
				arr[i][j+1] = tmp;
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				char tmp = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = tmp;
				
				check();
				
				tmp  = arr[j][i];
				arr[j][i] = arr[j+1][i];
				arr[j+1][i] = tmp;
			}
		}
		
		System.out.println(max);
	}
	
	
	public static void check() {//(x,y)기준 개수 구하기

		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(int j=0; j<n-1; j++) {
				if(arr[i][j] == arr[i][j+1]) {
					cnt++;
				} else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
		
		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(int j=0; j<n-1; j++) {
				if(arr[j][i] == arr[j+1][i]) {
					cnt++;
				} else {
					cnt = 1;
				}
				max = Math.max(max, cnt);
			}
		}
		
	}

}
