package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
	public static int r, max;
	public static String[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			String str = String.valueOf(num);
			arr = str.split("");
			if(r>str.length()) {
				r = str.length();
			}
			max = Integer.MIN_VALUE;
			
			change(0, r);
			
			sb.append("#").append(i+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	public static void change(int idx, int cnt) {
		if(cnt==0) {
			String answer = "";
			for(int i=0; i<arr.length; i++) {
				answer += arr[i];
			}
			max = Math.max(max, Integer.parseInt(answer));
			return;
		}
		
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				swap(i, j);
				change(idx+1, cnt-1);
				swap(i, j);
			}
		}
	}
	
	public static void swap(int x, int y) {
		String temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
