package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex5800 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int min = arr[0];
			int max = arr[arr.length-1];
			int gap = Integer.MIN_VALUE;
			for(int j=0; j<n-1; j++) {
				gap = Math.max(arr[j+1] - arr[j], gap);
			}
			
			System.out.println("Class " + (i+1));
			System.out.println("Max " + max + ", Min " + min + ", Largest gap " + gap);
		}
	}

}
