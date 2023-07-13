package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page226 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] d = new int[m+1];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<m+1; i++) {//초기값 설정
			d[i] = Integer.MAX_VALUE;
		}
		
		d[0] = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=arr[i]; j<m+1; j++) {
				if(d[j-arr[i]]!=Integer.MAX_VALUE) {
					d[j] = Math.min(d[j], d[j-arr[i]]+1);
				}
			}
		}
		
		if(d[m]==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(d[m]);
		}
	}

}
