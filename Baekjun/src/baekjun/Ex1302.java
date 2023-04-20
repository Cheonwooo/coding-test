package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ex1302 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0)+1);//value가 없을 경우 1추가
		}
		
		List<String> listArr = new ArrayList<String>(map.keySet());
		
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
