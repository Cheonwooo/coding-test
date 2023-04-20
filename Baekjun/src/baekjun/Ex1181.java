package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Ex1181 {

	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];
			
			for(int i=0; i<N; i++) {
				//길이 짧은것부터 - 오름차순
				//길이가 같으면 사전순으로 - 길이가 같은 것들은 사전순
				arr[i] = br.readLine();//단어
			}
			
			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String s1, String s2) {
					if(s1.length() == s2.length()) {
						return s1.compareTo(s2);
					} else {
						return s1.length() - s2.length();
					}
				}
			});
			
			for(int i=1; i<N; i++) {
				if(!arr[i].equals(arr[i-1])) {
					sb.append(arr[i]).append('\n');
				}
			}
			System.out.println(sb);
	}

}
