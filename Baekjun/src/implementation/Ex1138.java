package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex1138 {
	public static int n;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=n; i>=1; i--) {
			list.add(arr[i], i);
		}
		
		for(int v : list) {
			System.out.print(v + " ");
		}
		
	}
}
