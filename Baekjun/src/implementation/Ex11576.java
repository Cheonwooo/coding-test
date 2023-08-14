package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex11576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];

		
		st = new StringTokenizer(br.readLine());
		int num = 0;
		for(int i=m-1; i>=0; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			num += arr[i]*Math.pow(a, i);
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(num!=0) {
			list.add(num%b);
			num/=b;
		}
		
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i) + " ");
		}
		
	}

}
