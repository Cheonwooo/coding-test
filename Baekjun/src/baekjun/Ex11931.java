package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Ex11931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Integer[] new_arr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		
		Arrays.sort(new_arr, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		
		for(int v : new_arr) {
			sb.append(v).append("\n");
		}
		System.out.println(sb);
	}

}
