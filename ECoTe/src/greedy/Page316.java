package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] food_times = {99, 3, 1};
		int k = 5;
		
		System.out.println(solution(food_times, k));
	}
	
	public static int solution(int[] food_times, long k) {
		int answer = 0;
		
		int cnt = 1;
		int idx = 0;
		long sum = 0;
		
		for(int i=0; i<food_times.length; i++) {
			sum += food_times[i];
		}
		if(sum<=k) answer = -1;
		else {
			while(cnt<=k) {
				if(idx==food_times.length) idx = 0;
				
				if(food_times[idx]!=0) {//0이 아니라면
					food_times[idx]--;
					cnt++;
				}
				idx++;
			}
			if(idx==food_times.length) idx = 0;
			
			for(int i=idx; i<food_times.length; i++) {
				if(food_times[i]!=0) {
					answer = i+1;
					break;
				}				
				if(i==food_times.length-1) {
					i=-1;
				}
			}
		}
		
		return answer;
	}

}
