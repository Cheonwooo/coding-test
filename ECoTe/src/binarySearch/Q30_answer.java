package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q30_answer {
	public static ArrayList<ArrayList<String>> arr= new ArrayList<ArrayList<String>>();
	public static ArrayList<ArrayList<String>> reverseArr= new ArrayList<ArrayList<String>>();

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
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i=0; i<10001; i++) {
			arr.add(new ArrayList<String>());
			reverseArr.add(new ArrayList<String>());
		}
		
		for(int i=0; i<words.length; i++) {
			String word = words[i];
			arr.get(word.length()).add(word);
			word = (new StringBuilder(word)).reverse().toString();
			reverseArr.get(word.length()).add(word);
		}
		
		for(int i=0; i<10001; i++) {
			Collections.sort(arr.get(i));
			Collections.sort(reverseArr.get(i));
		}
		
		for(int i=0; i<queries.length; i++) {
			String q = queries[i];
			int cnt = 0;
			if(q.charAt(0) != '?') {//접미사가 '?'라면
				cnt = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
			} else {//접두사가 '?'라면
				q = (new StringBuilder(q)).reverse().toString();
				cnt = countByRange(reverseArr.get(q.length()), q.replaceAll("\\?", "a"), q.replaceAll("\\?", "z"));
			}
			
			ans.add(cnt);
		}
		
		int[] answer = new int[ans.size()];
		
		for(int i=0; i<ans.size(); i++) {
			answer[i] = ans.get(i);
		}
		return answer;
	}
	
	public static int countByRange(ArrayList<String> arr, String leftValue, String rightValue) {
		int rightIdx = upperBound(arr, rightValue, 0, arr.size());
		int leftIdx = lowerBound(arr, leftValue, 0, arr.size());
		return rightIdx - leftIdx;
	}
	
	public static int upperBound(ArrayList<String> arr, String target, int start, int end) {
		while(start<end) {
			int mid = (start + end) / 2;
			if(arr.get(mid).compareTo(target) > 0) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
	
	public static int lowerBound(ArrayList<String> arr, String target, int start, int end) {
		while(start<end) {
			int mid = (start + end) / 2;
			if(arr.get(mid).compareTo(target) >= 0) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return end;
	}
	

}
