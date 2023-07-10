package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if(n%2==0) {
			System.out.println(arr[(n/2)-1]);
		}else {
			System.out.println(arr[n/2]);
		}
	}
	
	public static class Antena implements Comparable<Antena>{
		int spot;
		int sum;
		
		public Antena(int spot, int sum) {
			this.spot = spot;
			this.sum = sum;
		}
		
		public int compareTo(Antena other) {
			if(this.sum == other.sum) {
				return Integer.compare(this.spot, other.spot);
			}
			return Integer.compare(this.sum, other.sum);
		}
	}
}
