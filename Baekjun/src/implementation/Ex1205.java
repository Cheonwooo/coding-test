package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex1205 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		
		if(n==0) {
			System.out.println(1);
		} else {
			int rank = 1;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				if(i==0) {
					arr[i][1] = rank;
					rank++;
					continue;
				}
				else {
					if(arr[i-1][0] == arr[i][0]) {
						arr[i][1] = arr[i-1][1];
						rank++;
					} else {
						arr[i][1] = rank;
						rank++;
					}
				}
			}
			boolean check = false;
			if(n==p) {
				for(int i=0; i<n; i++) {
					if(score==arr[n-1][0]) {
						System.out.println(-1);
						check = true;
						break;
					} else if(score >= arr[i][0]) {
						System.out.println(arr[i][1]);
						check = true;
						break;
					}
				}
			} else if(n<p) {
				for(int i=0; i<n; i++) {
					if(score==arr[n-1][0]) {
						System.out.println(arr[n-1][1]);
						check = true;
						break;
					} else if(score>=arr[i][0]) {
						System.out.println(arr[i][1]);
						check = true;
						break;
					} else if(score<arr[n-1][0]) {
						System.out.println(rank);
						check = true;
						break;
					}
				}
			}
			if(!check) {
				System.out.println(-1);
			}
		}	
	}
}
