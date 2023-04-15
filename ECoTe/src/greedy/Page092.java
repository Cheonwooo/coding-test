package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Page092 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int size = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		int repeat = Integer.parseInt(st.nextToken());
		int[] arr = new int[size];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);//오름차순
		
		int sum = 0;
		int cnt = 1;

		for(int i=0; i<time; i++, cnt++) {
			sum += arr[arr.length-1];
			
			if(cnt==repeat) {
				sum += arr[arr.length-2];
				i++;
				cnt=1;
			}
		}
		
		System.out.println(sum);
	}

}
