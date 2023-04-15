package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Page113 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =  Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<60; j++) {
				for(int k=0; k<60; k++) {
					String str = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
					if(str.contains("3")) cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
