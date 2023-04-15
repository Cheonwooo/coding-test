package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Page313 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i=0; i<str.length(); i++) {
			if(i==str.length()-1 && str.charAt(i)=='1') {
				cnt1++;
				continue;
			}
			if(i==str.length()-1 && str.charAt(i)=='0') {
				cnt2++;
				continue;
			}
			if(str.charAt(i)=='1' && str.charAt(i)!=str.charAt(i+1)) {
				cnt1++;
			}
			if(str.charAt(i)=='0' && str.charAt(i)!=str.charAt(i+1)) {
				cnt2++;
			}
		}
		System.out.println(Math.min(cnt1, cnt2));
	}

}
