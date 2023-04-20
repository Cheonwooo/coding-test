package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ex11652 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		
		for(int i=0; i<n; i++) {
			long num = Long.parseLong(br.readLine());
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		
		List<Long> listArr = new ArrayList<>(map.keySet());
		
		Collections.sort(listArr, (o1, o2) -> {
			if(map.get(o1)==map.get(o2)) {
				return ((Comparable) o1).compareTo(o2);
			} else {
				return map.get(o2).compareTo(map.get(o1));
			}
		});

		System.out.println(listArr.get(0));
	}
}
