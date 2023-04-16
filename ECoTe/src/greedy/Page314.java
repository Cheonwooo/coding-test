package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Page314 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1 1 2 3 9
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sum = arr[0];
		//arr : 1 1 2 3 9
		//sum : 0 1 2 4 7
		for(int i=1; i<n; i++) {
			System.out.println(sum);
			if(sum < arr[i]) {
				System.out.println(sum+1);
				break;
			}
			sum += arr[i];
		}
	}
}
