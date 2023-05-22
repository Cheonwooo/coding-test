package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Lv1ex5 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = {"mislav", "stanko", "mislav", "ana"};
		String[] arr2 = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(arr, arr2));
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		
		for(int i=0; i<participant.length; i++) {
			list.put(participant[i], 0);
		}
		
		for(int i=0; i<participant.length; i++) {
			list.put(participant[i], list.get(participant[i])+1);
		}
		
		for(int i=0; i<completion.length; i++) {
			list.put(completion[i], list.get(completion[i])-1);
		}
		
		answer = getKey(list, 1);
		return answer;
	}
	
	public static <K, V> K getKey(Map<K, V> map, V value) {
		for(K key : map.keySet()) {
			if(value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}

}
