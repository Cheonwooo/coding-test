package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Page311 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		
		Arrays.sort(arr);//오름차순
		
		// 3 3 4 5 5 5 6 7
		int k = 0;
		for(int i=0; i<n; i++) {
			if(arr[i]==i+1-k) {
				k = i+1;
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
