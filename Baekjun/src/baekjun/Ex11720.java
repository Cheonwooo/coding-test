package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex11720 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		String str = br.readLine();
		int sum = 0;
		for(int i=0; i<n; i++) {
			arr.add((int)(str.charAt(i))-48);
			sum += arr.get(i);
		}
		
		System.out.println(sum);
	}

}
