package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex14502 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][m];
		
		int num = 0;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) num++;
			}
		}
		
		int[] answer = new int[num*(num-1)*(num-2)];
		int size = answer.length;
		int[] dx = {1, -1, 0, 0};//{µ¿, ¼­, ³², ºÏ}
		int[] dy = {0, 0, 1, -1};
		int max = Integer.MIN_VALUE;
		
		while(true) {
			int cnt = 3;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j]==0) {
						arr[i][j]=1;
						cnt--;
						if(cnt==0) break;
						else continue;
					}
				}
				if(cnt==0) break;
			}
			size--;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j]==2) {
						for(int k=0; k<4; k++) {
							if(arr[n+dy[k]][m+dx[k]]==0) {
								arr[n+dy[k]][m+dx[k]]=2;
							}
						}
					}
				}
			}
			
			int ans = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j]==0) ans++;
				}
			}
			max = (max < ans) ? ans : max; 
			
			if(size==0) break;
		}
		
	}
	public static int[][] reset(int[][] arr, int n, int m){
		int[][] newArr = new int[n][m];
		
		
		return newArr;
	}
}
