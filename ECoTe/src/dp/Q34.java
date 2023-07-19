package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q34 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
			d[i] = 1;
		}
		
		Collections.reverse(list);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(list.get(j) < list.get(i)) {
					d[i] = Math.max(d[i], d[j] + 1);
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			max = Math.max(max, d[i]);
		}
		System.out.println(n-max);
		
	}

}
