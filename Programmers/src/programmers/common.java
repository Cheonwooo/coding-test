package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class common {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		
		int[] arr = {10, 100, 20, 150, 1, 100, 200};
		
		System.out.println(Arrays.toString(solution(k, arr)));
		/*String str = br.readLine();
		int[] arr = new int[100];
		
		int cnt = 0;
		
		if(str.length()==1){
			cnt=1;
		} else {
			for(int i=0; i<str.length(); i++) {
				arr[str.charAt(i)-'0']++;
				
				if(i==0) continue;
				
				
				for(int j=i-1; j>=0; j--) {
					if(str.charAt(i)!=str.charAt(j) && arr[str.charAt(i)-'0']==arr[str.charAt(j)-'0']) {//값이 같다면
						cnt++;
						if(i==str.length()-2) {
							cnt++;
						}
						arr = new int[100];
						break;
					} else if(arr[str.charAt(i) - '0'] != arr[str.charAt(j) - '0'] && i==str.length()-1) {
						cnt++;
						break;
					}
					
				}
				
			}
		}
		if(cnt == 0 ) {
			cnt = 1;
		}
		System.out.println(cnt);*/
	}
	
	public static int[] solution(int k, int[] score) {
		int[] answer = {};
		answer = new int[score.length];
		int[] rank = new int[score.length];
		
		for(int i=0; i<score.length; i++) {
			rank[i] = score[i];
			
			Integer[] list = Arrays.stream(rank).boxed().toArray(Integer[]::new);
			
			Arrays.sort(list, Collections.reverseOrder());//내림차순 정렬
			
			if(i<k) {
				answer[i] = list[i];
			} else {
				answer[i] = list[k-1];
			}
		}
		return answer;
	}
}
