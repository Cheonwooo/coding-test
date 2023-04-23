package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1026 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			sum += arrA[i]*arrB[arrB.length-1-i];
		}
		System.out.println(sum);
	}
	

}
