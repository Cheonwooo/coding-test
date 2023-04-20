package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex2693ver2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		
		StringTokenizer st;
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			
			Integer[] sortArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
			Arrays.sort(sortArr, Collections.reverseOrder());
			
			System.out.println(sortArr[2]);
		}
	}

}
