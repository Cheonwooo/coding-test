package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lv1ex8 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nums = {1,2,7,6,4};
		
		System.out.println(solution(nums));
	}
	
	public static int solution(int[] nums) {
		int answer = 0;
		
		for(int i=0; i<nums.length-2; i++) {
			for(int j=i+1 ;j<nums.length-1; j++) {
				for(int k=j+1; k<nums.length; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					System.out.println(sum);
					if(check(sum)) {
						answer++;
					}
				}
			}
		}
		
		return answer;
	}
	
	public static boolean check(int num) {//소수 판독기
		boolean check = true;
		
		if(num==1) {
			check = false;
		}
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) {
				check = false;
				break;
			}
		}
		if(check) {
			check = true;
			System.out.println("true");
		}
		
		return check;
	}
}
