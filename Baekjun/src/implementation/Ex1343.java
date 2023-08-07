package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1343 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split("");
		
		int cnt = 0;
		String answer = "";
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("X")) {
				cnt++;
				if(i==arr.length-1) {
					if(cnt%4!=0 && cnt%2!=0) {
						answer="-1";
						break;
					} 
					if(cnt/4!=0) {//4로 나누어진다면
						for(int j=0; j<cnt/4; j++) {
							answer+="AAAA";
						}
						cnt%=4;
					}
					if(cnt/2!=0) {//2로 나누어진다면
						for(int j=0; j<cnt/2; j++) {
							answer+="BB";
						}
						cnt%=2;
					}
				}
			} else {//"."인 경우
				if(cnt!=0 && cnt%4!=0 && cnt%2!=0) {
					answer="-1";
					break;
				} 
				if(cnt/4!=0) {//4로 나누어진다면
					for(int j=0; j<cnt/4; j++) {
						answer+="AAAA";
					}
					cnt%=4;
				}
				if(cnt/2!=0) {//2로 나누어진다면
					for(int j=0; j<cnt/2; j++) {
						answer+="BB";
					}
					cnt%=2;
				}
				answer += ".";
			}
		}
		System.out.println(answer);
	}

}
