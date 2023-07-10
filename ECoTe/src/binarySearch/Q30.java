package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

/*
 * 6
frodo
front
frost
frozen
frame
kakao
5
fro??
????o
fr???
fro???
pro?
 */
public class Q30 {
	public static HashMap<Integer, Pair> mapLen = new HashMap<Integer, Pair>();
	public static HashMap<String, Pair> mapStr = new HashMap<String, Pair>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] words = new String[n];
		
		
		for(int i=0; i<n; i++) {
			words[i] = br.readLine();
		}
		
		int m = Integer.parseInt(br.readLine());
		String[] queries = new String[m];
		
		for(int i=0; i<m; i++) {
			queries[i] = br.readLine();
		}
	
		System.out.println(Arrays.toString(solution(words, queries)));
	}
	
	public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
      //중복제거
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        String[] new_words = set.toArray(new String[0]);
        
        Arrays.sort(new_words, new Comparator<String>() {
        	public int compare(String o1, String o2) {
        		if(o1.length() == o2.length()) {
        			return (int)o1.compareTo(o2);
        		}
        		return o1.length() - o2.length();
        	}
        });
        
        changeLen(new_words);
        changeStr(queries);
        
        for(int i=0; i<queries.length; i++) {
        	Pair nowStr = mapStr.get(queries[i]);
        	int x =	nowStr.getX();//'?'의 위치
        	int y =	nowStr.getY();
        	int len_x = 0;
        	int len_y = 0;
        	Pair nowLen = mapLen.get(queries[i].length());
        	if(nowLen == null) {
        		answer[i] = 0;
        		continue;
        	} else {
        		len_x = nowLen.getX();//queries[i]의 길이
            	len_y = nowLen.getY();
        	}
        	
        	
        	int cnt = 0;
        	for(int j=len_x; j<=len_y; j++) {
        		if(x == 0 && y==new_words[j].length()-1) {//?????인 경우
        			cnt = y - x + 1;
        			break;
        		} else if(x == 0) {//접미사인 경우
        			String newStr = new_words[j].substring(y+1);
        			if(newStr.equals(queries[i].substring(y+1))) {
        				cnt++;
        			}
        		} else if(y == new_words[j].length()-1) {//접두사인 경우
        			String newStr = new_words[j].substring(0, x);
        			if(newStr.equals(queries[i].substring(0, x))) {
        				cnt++;
        			}
        		}
        	}
        	answer[i] = cnt;
        }
        
        return answer;
    }
	
	public static void changeLen(String[] new_words) {
		int start = 0;
        int end = 0;
        for(int i=0; i<new_words.length; i++) { //길이에 따른 인덱스
        	if(i > 1) {
        		if(new_words[i].length() != new_words[i-1].length()) {
        			end = i-1;
        			mapLen.put(new_words[i-1].length(), new Pair(start, end));
        			start = i;
        		} 
        		if(i==new_words.length-1) {
        			end = i;
        			mapLen.put(new_words[i].length(), new Pair(start, end));
        		}
        	}
        }
	}
	
	public static void changeStr(String[] queries) {
		int start = 0;
        int end = 0;
        for(int i=0; i<queries.length; i++) {
        	if(queries[i].charAt(0)=='?' && queries[i].charAt(queries[i].length()-1)=='?') {
        		start = 0;
        		end = queries[i].length()-1;
        		mapStr.put(queries[i], new Pair(start, end));
        		continue;
        	}else if(queries[i].charAt(0)=='?') {//접미사
    			start = 0;
    		}else if(queries[i].charAt(queries[i].length()-1)=='?') {//접두사
    			end = queries[i].length()-1;
    		}
        	for(int j=1; j<queries[i].length(); j++) {
        		if(queries[i].charAt(j-1)=='?' &&  queries[i].charAt(j)!='?') {//접미사
        			end = j-1;//j로 할경우 ?????로 인식할 수 있음
        			mapStr.put(queries[i], new Pair(start, end));
        		}
        		if(queries[i].charAt(j-1)!='?' && queries[i].charAt(j)=='?') {//접두사
        			start = j;//j-1로 할경우 ?????로 인식할 수 있음
        			mapStr.put(queries[i], new Pair(start, end));
        		}
        	}
        }
	}
	
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
}
