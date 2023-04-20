package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1946 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			
			for(int j=0; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				arr[idx] = value;
			}
			
			int cnt = 1;
			
			int comp = arr[1];
			
			for(int j=2; j<=N; j++) {
				if(arr[j] < comp) {
					cnt++;
					comp = arr[j];
				}
			}
			System.out.println(cnt);
		}
		
		
	}
}
