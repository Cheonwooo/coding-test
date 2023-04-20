package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Ex11478 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=1; i<str.length()+1; i++) {
			int startindex = 0;
			while(startindex+i <= str.length()) {
				map.put(str.substring(startindex, startindex+i), 0);
				startindex++;
			}
		}
		System.out.println(map.size());
	}

}
