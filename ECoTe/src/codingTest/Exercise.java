package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise {
	public static int n;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException{//배열이 주어졌을때 3가지 수를 뽑는 경우의 수를 모두 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		

			String str_num = br.readLine().replaceAll("[^0-9]", " ");
			String[] str2_num = str_num.split(" ");
			int num = 0;
			for(int i=1; i<str2_num.length; i++) {
				num += Integer.parseInt(str2_num[i])*(int)Math.pow(10, str2_num.length-1-i);
			}
		System.out.println(num);
		
	}
	
	
}
