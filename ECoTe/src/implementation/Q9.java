package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q9 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split("");
		int min = Integer.MAX_VALUE;
		
		if(str.length == 1) {
			min = 1;
		} else {
			int cnt = 0;
			
			for(int i=1; i<=str.length/2; i++) {
				Stack<String> s = new Stack<>();
				cnt = 0;
				
				for(int j=0; j<str.length; j+=i) {
					
					String new_str = "";
					int idx = j;
					
					while(new_str.length()!=i) {
						if(idx == str.length) break;
						else {
							new_str += str[idx];
							idx++;
						}
					}
					
					
					
					if(s.isEmpty()) {//초기값 넣기
						s.push(new_str);
						cnt++;
//						System.out.println("초기값 : " + new_str + ", cnt : " + cnt);
					} else {//앞에 값이 있다면
						
						if(s.peek().equals(new_str)) {
							cnt++;
//							System.out.println("앞의 것과 같음 : " + new_str + ", cnt : " + cnt);
						} else {//다르다면
							if(cnt==1) {
								s.push(new_str);
//								System.out.println("앞의 것과 다르고 cnt=1인 상태 : " + new_str);
							} else {
								String word = s.peek();
								s.pop();
								s.push(String.valueOf(cnt));
								s.push(word);
								s.push(new_str);
//								System.out.println("앞의 것과 다르고 cnt!=1인 상태 : " + new_str + ", cnt : " + cnt);
								cnt = 1;
							}
						}				
					}
					
					if(j+i==str.length) {
						if(cnt!=1) {
							String last_word = s.peek();
							s.pop();
							s.push(String.valueOf(cnt));
							s.push(last_word);
						}
					}
//					for(String v : s) {
//						System.out.print(v);
//					}
//					System.out.println();
				}
				String str_len = "";
				for(String v : s) {
					str_len += v;
				}
				
				min = Math.min(min, str_len.length());
//				System.out.println("최소 길이 : " + min);
			}
			System.out.println(min);
		}

	}

}
