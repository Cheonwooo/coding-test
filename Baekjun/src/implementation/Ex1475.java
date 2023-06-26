package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex1475 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String num = String.valueOf(n);
		int[] arr = new int[10];
		
		for(int i=0; i<num.length(); i++) {
			arr[num.charAt(i)-'0']++;
		}
		arr[6] += arr[9];
		arr[9] = 0;
		
		if(arr[6]%2==0) {//Â¦¼ö
			arr[6] /= 2;
		} else {//È¦¼ö
			arr[6] = arr[6]/2 + 1;
		}
		Arrays.sort(arr);
		
		System.out.println(arr[9]);
	}

}
