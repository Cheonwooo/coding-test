package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page220 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] d = new int[100];
		
		d[0] = arr[0];
		d[1] = Math.max(d[0], arr[1]);
		
		for(int i=2; i<n; i++) {
			d[i] = Math.max(d[i-1], d[i-2]+arr[i]);
		}
		
		System.out.println(d[n-1]);
	}

}
