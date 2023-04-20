package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2470 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];//용액 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);//오름차순
		
		int sum = 0;
		int lo = 0;
		int hi = arr.length-1;
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int temp = 0;
		while(lo<hi) {
			sum = arr[lo] + arr[hi];
			temp = Math.abs(sum);
			if(temp<min) {
				min = temp;
				left = lo;
				right = hi;
			}
			
			if(sum>0) {
				hi--;
			} else {
				lo++;
			}
		}
		
		System.out.println(arr[left] + " " + arr[right]);
			
	}

}
