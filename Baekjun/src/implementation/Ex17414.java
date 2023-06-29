package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Ex17414 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		Queue<Integer> q = new LinkedList<>();//<,>의 인덱스 저장
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='<' || str.charAt(i)=='>') {//<가 나오면 >가 무조건 다음에 나옴
				q.add(i);
			}
		}
		
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder sb;
		String reverse = "";
		
		
		if(q.size()==0) {//태그가 한번도 안나왔다면
			
			String[] answer = str.split(" ");
			for(int i=0; i<answer.length; i++) {
				sb = new StringBuilder(answer[i]);
				
				reverse += sb.reverse().toString() + " ";
			}
		} else {
			
			if(str.charAt(0)!='<') {
				int idx = q.peek();
				String[] sub = str.substring(0, idx).split(" ");
				for(int i=0; i<sub.length; i++) {	
					sb = new StringBuilder(sub[i]);
					list.add(sb.reverse().toString());
					
					if(i!=sub.length-1) {
						list.add(" ");
					}
				}
			}
			
			int temp = Integer.MAX_VALUE;
			int cnt = 0;
			while(!q.isEmpty()) {
				int idx = q.poll();

				if(temp == Integer.MAX_VALUE) {//초기값 설정
					temp = idx;
					cnt++;
					continue;
				}
				/*
				 * cnt가 홀수일 때 <>사이값
				 * cnt가 짝수일 때 ><사이값
				 */
				
				if(cnt%2!=0) {
					list.add(str.substring(temp,idx+1));
				} else if(temp!=idx-1 && cnt%2==0){
					String[] sub = str.substring(temp+1, idx).split(" ");
					
					for(int i=0; i<sub.length; i++) {	
						sb = new StringBuilder(sub[i]);
						list.add(sb.reverse().toString());
						
						if(i!=sub.length-1) {
							list.add(" ");
						}
					}
				}
				
				temp = idx;
				cnt++;
				
				if(q.size()==0 && idx<str.length()-1) {
					String[] sub = str.substring(temp+1).split(" ");
					
					for(int i=0; i<sub.length; i++) {	
						sb = new StringBuilder(sub[i]);
						list.add(sb.reverse().toString());
						
						if(i!=sub.length-1) {
							list.add(" ");
						}
					}
				}
			}
			for(int i=0; i<list.size(); i++) {
				reverse += list.get(i);
			}
		}
		System.out.println(reverse);
	}
}
