package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Ex10757 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int max_length = Math.max(str1.length(), str2.length());
		
		int[] arr1 = new int[max_length + 1];
		int[] arr2 = new int[max_length + 1];
		
		for(int i=str1.length()-1, idx=0; i>=0; i--, idx++) {
			arr1[idx] = str1.charAt(i) - '0';
		}
		
		for(int i=str2.length()-1, idx=0; i>=0; i--, idx++) {
			arr2[idx] = str2.charAt(i) - '0';
		}
		
		for(int i=0; i<max_length; i++) {
			int value = arr1[i] + arr2[i];
			arr1[i] = value%10;
			arr1[i+1] += value/10;
		}
		
		StringBuilder sb = new StringBuilder();
		if(arr1[max_length] != 0) {
			sb.append(arr1[max_length]);
		}
		
		for(int i=max_length-1; i>=0; i--) {
			sb.append(arr1[i]);
		}
		System.out.println(sb);
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger num1 = new BigInteger(st.nextToken());
		BigInteger num2 = new BigInteger(st.nextToken());
		
		num1 = num1.add(num2);
		
		System.out.println(num1.toString());*/
		
		
	}

}
