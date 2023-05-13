package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise {
	public static int cnt;
	public static String[] arr;
	public static int max;
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr = st.nextToken().split("");
        	cnt = Integer.parseInt(st.nextToken());
        	
        	max = 0;
        	if(cnt > arr.length) {
        		cnt = arr.length;//num¿« ±Ê¿Ã
        	}
        	
        	dfs(0, 0);
        	
        	sb.append("#").append(i+1).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
		
        
	}
	public static void swap(int x, int y) {
		String temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	
	public static void dfs(int start, int count) {
		if(count == cnt) {
			String result = "";
			for(int i=0; i<arr.length; i++) {
				result += arr[i];
			}
			max = Math.max(max, Integer.parseInt(result));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				swap(i, j);
				dfs(i, count + 1);
				swap(i, j);
			}
		}
	}
}
