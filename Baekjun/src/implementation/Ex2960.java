package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2960 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[n+1];
		
		
		int cnt = 0;
		int idx = 2;
		int answer = 0;
		while(true) {
			if(arr[idx]) {
				idx++;
				continue;
			}
			boolean check = false;
			if(idx==2) {
				if(!arr[idx]) {
					arr[idx] = true;
					cnt++;
					if(cnt==k) {
						answer = 2;
						break;
					}
				}
				
			} else {//idx가 2이상인 경우
				for(int i=2; i<=Math.sqrt(idx); i++) {
					if(idx%i==0) {
						check = true;
						break;
					}
				}
				if(check) continue;//소수가 아니라면
				else {//소수라면
					if(!arr[idx]) {
						arr[idx] = true;
						cnt++;
					}
				}
			}
			if(!check) {
				for(int i=idx; i<n+1; i+=idx) {
					if(!arr[i]) {
						arr[i] = true;
						cnt++;
					}
					if(cnt==k) {
						answer = i;
						break;
					}
				}
				idx++;
			}
			if(cnt==k) break;
		}
		System.out.println(answer);
	}

}
