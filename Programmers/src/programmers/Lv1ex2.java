package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://school.programmers.co.kr/learn/courses/30/lessons/42862
//체육복

public class Lv1ex2 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 8;
		int[] lost = {2,3,5,7};
		int[] reserve = {1,4,6,8};
		
		System.out.println(solution(n, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
		boolean[] check = new boolean[n];//true인 경우 수업 참여 가능
		boolean[] fakecheck = new boolean[n];
		boolean[] realcheck = new boolean[n];
		
		for(int i=0; i<n; i++) {
			fakecheck[i] = true;
		}
		for(int i=0; i<reserve.length; i++) {
			check[reserve[i]-1] = true;
			realcheck[reserve[i]-1] = true;
		}
		
		for(int i=0; i<lost.length; i++) {
			check[lost[i]-1] = false;
			fakecheck[lost[i]-1] = false;
		}
		
		for(int i=0; i<lost.length; i++) {
			if(lost[i]==1) {
				if(realcheck[lost[i]]) {
					check[lost[i]-1]=true;
					realcheck[lost[i]]=false;
				} else continue;
			} else if(lost[i]==n) {
				if(realcheck[lost[i]-2]) {
					check[lost[i]-1]=true;
					realcheck[lost[i]-2] = false;
				} else continue;
			} else if(lost[i] >= 2) {
				if(realcheck[lost[i]-2]) {
					check[lost[i]-1]=true;
					realcheck[lost[i]-2]=false;
				} else if(realcheck[lost[i]]) {
					check[lost[i]-1]=true;
					realcheck[lost[i]]=false;
				} else continue;
			}
		}
		for(int i=0; i<n; i++) {
			if(fakecheck[i]) {
				check[i] = true;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(check[i]) {
				System.out.println(i);
				answer++;
			}
		}
		
		return answer;
	}
}
