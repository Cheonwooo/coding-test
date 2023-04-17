package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Page323 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int sub = 1;
		int len = s.length()/2;
		int min = Integer.MAX_VALUE;
		
		while(sub<=len) {
			String new_str = s;
			String sub_str="";//끝부분 자른 str 담을 변수
			if(s.length()%sub!=0) {//s의 끝이 남는다면
				sub_str = s.substring(s.length()-s.length()%sub);//s의 끝부분
				new_str = s.substring(0, s.length()-s.length()%sub);
			}
			
			String[] str = new String[s.length()/sub];
			
			int k = 0;
			for(int i=0; i<str.length; i++) {//문자열 자르기
				str[i] = new_str.substring(k*sub, k*sub+sub);
				k++;
			}
			
			int cnt = 1;
			
			for(int i=0; i<str.length-1; i++) {
				if(str[i].equals(str[i+1])) {//앞뒤가 같다면
					if(i==str.length-2) {
						cnt++;
						sub_str += cnt + str[i];
					} else {
						cnt++;
					}
				} else {
					
					if(cnt==1) {
						sub_str += str[i];
					} else {
						sub_str += cnt + str[i];
						cnt=1;
					}
					if(i==str.length-2) {
						sub_str += str[i+1];
					}
					
				}
			}
			
			min = Math.min(min, sub_str.length());

			sub++;
		}
		System.out.println(min);
	}

}
