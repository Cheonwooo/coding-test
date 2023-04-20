package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex1620 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] list = new String[N];
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<N; i++) {
			String key = br.readLine();
			map.put(key, i);
			list[i] = key;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(isNumber(str)) {
				sb.append(list[Integer.parseInt(str)-1]).append('\n');
			} else {
				sb.append(map.get(str)+1).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static boolean isNumber(String str) {
		boolean check = false;
		
		try {
			Integer.parseInt(str);
			check = true;
		} catch (NumberFormatException e) {
			
		}
		return check;
	}

}
