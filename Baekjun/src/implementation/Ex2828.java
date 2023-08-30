package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2828 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int j = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end = m;
		int cnt = 0;
		
		for(int i=0; i<j; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num>end) {
				cnt += num-end;
				end = num;
				start = end-(m-1);
			} else if(num<start) {
				cnt += start-num;
				start = num;
				end = start+(m-1);
			}
		}
		System.out.println(cnt);
	}
}
