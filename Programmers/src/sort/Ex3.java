package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(arr));
	}
	
	public static int solution(int[] ciations) {
		
		
		Arrays.sort(ciations);
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<1000; i++) {
			for(int j=0; j<ciations.length; j++) {
				if(ciations[j] >= i && ciations.length-j+1 >= i && j <= i) {
					max = Math.max(max, i);
				}
			}
		}
		
		
		return max;
	}
}
