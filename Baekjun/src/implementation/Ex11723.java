package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11723 {
	public static boolean[] check;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		check = new boolean[21];
		
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			String func = st.nextToken();
			
			if(func.equals("all") || func.equals("empty")) {
				function(func, 0);
			}
			else {
				int num = Integer.parseInt(st.nextToken());
				
				function(func, num);
			}
			
		}
		System.out.println(sb);
	}
	
	public static void function(String func, int num) {
		
		if(func.equals("add")) {
			if(check[num]) return;
			else check[num] = true; 
		} else if(func.equals("remove")) {
			if(!check[num]) return;
			else check[num] = false;
		} else if(func.equals("check")) {
			if(check[num]) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		} else if(func.equals("toggle")) {
			if(check[num]) check[num] = false;
			else check[num] = true;
		} else if(func.equals("all")) {
			for(int i=0; i<check.length; i++) {
				check[i] = true;
			}
		} else if(func.equals("empty")) {
			check = new boolean[21];
		}
	}

}
