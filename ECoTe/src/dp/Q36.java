package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q36 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int n = str1.length();
		int m = str2.length();
		int[][] arr = new int[n+1][m+1];
		
		for(int i=1; i<n+1; i++) {
			arr[i][0] = i;
		}
		
		for(int i=1; i<m+1; i++) {
			arr[0][i] = i;
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					arr[i][j] = arr[i-1][j-1];
				} else {
					arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j],  arr[i][j-1]))+1;
				}
			}
		}
		System.out.println(arr[n][m]);
	}

}
