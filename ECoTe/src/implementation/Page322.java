package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Page322 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String word = str.replaceAll("[^A-Z]", "");//알파벳만 추출
		int num = Integer.parseInt(str.replaceAll("[^0-9]", ""));
		
		String[] arr = new String[word.length()];
		
		for(int i=0; i<word.length(); i++) {
			arr[i] = String.valueOf(word.charAt(i));
		}
		
		Arrays.sort(arr);
	
		int sum = 0;
		int len = (int)(Math.log10(num)+1);//num의 자리수
		for(int i=0; i<len; i++) {
			sum += num%10;
			num /= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		sb.append(sum);
		
		System.out.println(sb);
	}

}
