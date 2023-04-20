package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1085 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[4];
		arr[0] = x;
		arr[1] = y;
		arr[2] = w-x;
		arr[3] = h-y;
		
		int min = arr[0];
		for(int i=0; i<arr.length-1; i++) {
			min = (min < arr[i+1]) ? min : arr[i+1];
		}
		
		System.out.println(min);
	}

}
