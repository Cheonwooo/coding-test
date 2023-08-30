package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex1251 {
	public static ArrayList<Integer> list;
	public static ArrayList<String> answer = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		boolean[] visited = new boolean[len-1];
		
		comb(str, visited, 0, 2);
		
		Collections.sort(answer);
		
		System.out.println(answer.get(0));
	}
	
	public static void comb(String str, boolean[] visited,int start, int r) {
		if(r==0) {
			list = new ArrayList<Integer>();
//			for(int i=0; i<str.length()-1; i++) {
//				if(visited[i]) {
//					System.out.print(i+1);
//				}
//			}System.out.println();
			list = new ArrayList<Integer>();
			for(int i=0; i<str.length()-1; i++) {
				if(visited[i]) {
					list.add(i);
				}
			}
			String str1 = str.substring(0, list.get(0)+1);
			String str2 = str.substring(list.get(0)+1, list.get(1)+1);
			String str3 = str.substring(list.get(1)+1);
			
			String newStr = reverse(str1) + reverse(str2) + reverse(str3);
			
			answer.add(newStr);
			return;
		}
		
		for(int i=start; i<str.length()-1; i++) {
			visited[i] = true;
			comb(str, visited, i+1, r-1);
			visited[i] = false;
		}
	}
	
	public static String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		
		String reverseStr = sb.reverse().toString();
		
		return reverseStr;
		
	}
}
