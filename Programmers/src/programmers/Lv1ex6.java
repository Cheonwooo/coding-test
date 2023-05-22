package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lv1ex6 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "1S2D*3T";
		
		System.out.println(solution(str));
		
	}
	
	public static int solution(String dartResult) {
		int answer = 0;
		
		int[] num = new int[3];
		
		String newDR = dartResult.replace("10", "ab");
		String newDR2 = newDR.replaceAll("[0-9]", "a");

		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<newDR2.length();i++) {
			if(newDR2.charAt(i)=='a') {//숫자들의 인덱스 3개 저장
				list.add(i);
			}
		}
		list.add(newDR.length());
		
		int sum = 0;
		for(int i=0; i<3; i++) {
			String newResult = dartResult.substring(list.get(i),list.get(i+1));
			sum = Integer.parseInt(newResult.replaceAll("[^0-9]", ""));//숫자 체크
			String mark = newResult.replaceAll("[0-9]", "").replaceAll("[A-Z]", "");
			num[i] = cal(sum, newResult);
			
			if(mark.equals("*")) {
				if(i==0) {
					num[i] *= 2;
				} else {
					num[i-1] *= 2;
					num[i] *= 2;
				}
			} else if(mark.equals("#")) {
				num[i] *= (-1);
			} else {
				num[i] = num[i];
			}
		}
		
		for(int i=0; i<num.length; i++) {
			answer += num[i];
		}
		
		return answer;
	}
	
	public static int cal(int sum, String str) {
		int num = 0;
		
		str = str.replaceAll("[^A-Z]", "");
		
		if(str.equals("S")) {
			num = sum;
		} else if(str.equals("D")) {
			num = (int)Math.pow(sum, 2);
		} else {
			num = (int)Math.pow(sum, 3);
		}
		
		return num;
	}
	

}
