package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lv1ex7 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 6;
		int[] arr1 = {46,33,33,22,31,50};
		int[] arr2 = {27,56,19,14,14,10};
		
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		
		for(int i=0; i<arr1.length; i++) {
			String str1 = Integer.toString(arr1[i], 2);
			String str2 = Integer.toString(arr2[i], 2);
			
			String newStr1 = check2(n, str1);
			String newStr2 = check2(n, str2);
			String str3 = check(n, newStr1, newStr2);
			
			String str4 = change(str3);
			answer[i] = str4;
		}
		
		return answer;
	}
	
	public static String check(int n, String str1, String str2) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			if(str1.charAt(i) == '0' && str2.charAt(i) == '0') {
				sb.append(0);
			} else {
				sb.append(1);
			}
		}
		
		String str = sb.toString();
		return str;
	}
	
	public static String check2(int n, String str) {
		String str2 = "";
		
		int num = str.length();
		int abs = n-num;
		
		StringBuilder sb2 = new StringBuilder();
		if(abs==0) {
			str2 = str;
		} else {
			for(int i=0; i<abs; i++) {
				sb2.append(0);
			}
			sb2.append(str);
			str2 = sb2.toString();
		}
		
		return str2;
	}
	
	public static String change(String str) {
		str = str.replace("1", "#").replace("0", " ");
		
		return str;
	}
}
