package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1712 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] arr = new long[3];//A,B,C값 저장할 배열
		long count = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		if(arr[1] > arr[2] || arr[1] == arr[2]) {
			count = -1;
		} else {
			count = arr[0] / (arr[2] - arr[1]) + 1;
		}
		
		System.out.println(count);
	}
}
