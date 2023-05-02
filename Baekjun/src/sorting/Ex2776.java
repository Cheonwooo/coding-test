package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex2776 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		while(t!=0) {//hashmap»ç¿ë
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				int num = Integer.parseInt(st.nextToken());
				map.put(num, map.getOrDefault(num, 0)+1);
			}
			
			int m = Integer.parseInt(br.readLine());
			int[] arr2 = new int[m];
			
			st = new StringTokenizer(br.readLine());
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
				if(map.containsKey(arr2[i])) {
					if(i==m-1) {
						sb.append(1);
					} else {
						sb.append(1).append("\n");
					}
				} else {
					if(i==m-1) {
						sb.append(0);
					} else {
						sb.append(0).append("\n");
					}
				}
			}
			
			System.out.println(sb);
			t--;
		}
	}

}
