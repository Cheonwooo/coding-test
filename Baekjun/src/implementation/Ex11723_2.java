package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11723_2 {
	public static boolean[] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new boolean[21];
	
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			
			if(str.length == 2) {
				function(str[0], Integer.parseInt(str[1]));
			} else {
				function(str[0], 0);
			}
		}
		System.out.println(sb);
	}
	
	public static void function(String func, int num) {
		if(func.equals("add")) {
			arr[num] = true;
		} else if(func.equals("remove")) {
			arr[num] = false;
		} else if(func.equals("check")) {
			if(arr[num]) sb.append(1).append("\n");
			else sb.append(0).append("\n");;
		} else if(func.equals("toggle")) {
			if(arr[num]) arr[num] = false;
			else arr[num] = true;
		} else if(func.equals("all")) {
			for(int i=0; i<arr.length; i++) {
				arr[i] = true;
			}
		} else if(func.equals("empty")) {
			for(int i=0; i<arr.length; i++) {
				arr[i] = false;
			}
		}
	}

}
