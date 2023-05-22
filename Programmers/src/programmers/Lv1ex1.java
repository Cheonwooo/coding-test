package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://school.programmers.co.kr/learn/courses/30/lessons/42889
//½ÇÆÐÀ²

public class Lv1ex1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = {};
		
		int idx=1;
		int stack = 0;
		while(idx<=N) {
			if(idx==1) {
				for(int i=0; i<stages.length; i++) {
					if(stages[i]<=idx) {
						stack++;
					}
				}
			} else { //idx>1
				
			}
			
			
		}
		
		return answer;
	}
}
