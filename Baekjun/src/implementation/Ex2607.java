package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2607 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int answer = 0;
		
		boolean[] checkSt;
		boolean[] checkLo;
		for(int i=0; i<n-1; i++) {
			String newStr = br.readLine();
			
			checkSt = new boolean[str.length()];
			checkLo = new boolean[newStr.length()];
			String st = str;
			String lo = newStr;
			if(str.length()>newStr.length()) {
				st = newStr;
				lo = str;
				checkSt = new boolean[newStr.length()];
				checkLo = new boolean[str.length()];
			}
			
			for(int j=0; j<st.length(); j++) {
				char c = st.charAt(j);
				
				for(int k=0; k<lo.length(); k++) {
					if(!checkLo[k] && c == lo.charAt(k)) {
						checkLo[k] = true;
						checkSt[j] = true;
						break;
					}
				}
			}
			
			int stCnt = 0;
			int loCnt = 0;
			for(int j=0; j<st.length(); j++) {
				if(!checkSt[j]) stCnt++;
			}
			for(int j=0; j<lo.length(); j++) {
				if(!checkLo[j]) loCnt++;
			}
//			System.out.println(stCnt + " " + loCnt);
			
			if(stCnt<=1 && loCnt<=1){
				answer++;
			}
		}
		System.out.println(answer);
	}

}
