package baekjun;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Ex5086 {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>() {{
			put(1, "A");
			put(2, "B");
			put(3, "C");
		}};
		
		for(Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
		
		for(Integer i : map.keySet()) {
			System.out.println(i + map.get(i));
		}
		
		Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry<Integer, String> entry = entries.next();
			System.out.println(entry.getKey() + entry.getValue());
		};
		
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			System.out.println(key + map.get(key));
		}
	}

}
