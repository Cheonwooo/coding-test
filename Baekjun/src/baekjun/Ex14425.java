package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14425 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] arr = new String[N];
		String[] list = new String[M];
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		for(int i=0; i<M; i++) {
			list[i] = br.readLine();
			for(int j=0; j<arr.length; j++) {
				if(list[i].equals(arr[j])) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
	
	

}
