package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());//시작시간
			arr[i][1] = Integer.parseInt(st.nextToken());//끝나는시간
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
		});
		
		int cnt = 1;
		int endTime = arr[0][1];
		
		for(int i=1; i<N; i++) {
			if(endTime <= arr[i][0]) {
				cnt++;
				endTime = arr[i][1];
			}
		}
		System.out.println(cnt);
		
	}

}
