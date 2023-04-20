package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16953 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		long cnt = 0;
		while(b > a) {
			if(b%10!=1 && b%2!=0) {
				cnt=-1;
				break;
			} else {
				if(b%10 == 1) {
					b /= 10;
					cnt++;
				} else {
					b /= 2;
					cnt++;
				}
			}
			
			
			if(b==a) {
				cnt++;
			} else if(b < a) {
				cnt = -1;
			}
		}
		
		System.out.println(cnt);
	}

}
