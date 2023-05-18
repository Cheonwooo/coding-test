package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] list = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<n; i++) {
			boolean[] check = new boolean[1001];
			int min = arr[i];
			int cnt = 1;
			for(int j=i-1; j>=0; j--) {
				if(min > arr[j] && !check[arr[j]]) {
					check[arr[j]] = true;
					min = arr[j];
					cnt++;
				}
			}
			list[i] = cnt;
		}
		Arrays.sort(list);
		System.out.println(list[list.length-1]);
	}

}
