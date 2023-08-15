package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1969 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] arr = new String[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		String answer = "";
		int sum = 0;
		for(int i=0; i<m; i++) {
			int max = Integer.MIN_VALUE;
			int[] map = new int[4];//0:A, 1:C, 2:G, 3:T
			for(int j=0; j<n; j++) {
				if(arr[j].charAt(i)=='A') {
					map[0]++;
				} else if(arr[j].charAt(i)=='C') {
					map[1]++;
				} else if(arr[j].charAt(i)=='G') {
					map[2]++;
				} else if(arr[j].charAt(i)=='T') {
					map[3]++;
				}
			}
			
			int idx = 0;
			for(int j=0; j<4; j++) {
				if(max < map[j] || (max==map[j] && idx>j)){
					max = map[j];
					idx = j;
				}
			}
			
			if(idx==0) {
				answer += "A";
			} else if(idx==1) {
				answer += "C";
			} else if(idx==2) {
				answer += "G";
			} else if(idx==3) {
				answer += "T";
			}
			
			sum += n-max;
		}
		
		System.out.println(answer);
		System.out.println(sum);
		
	}

}
