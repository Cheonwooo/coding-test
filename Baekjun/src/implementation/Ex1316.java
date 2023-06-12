package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		
		
		
		int answer = 0;
		for(int i=0; i<n; i++) {
			
			String str = br.readLine();
			boolean[] check = new boolean[27];
			boolean visited = false;
			
			if(str.length()<=2) {
				answer++;
				continue;
			}
			
			for(int j=0; j<str.length(); j++) {
				if(!check[str.charAt(j)-'a']) {//처음 나오는 단어라면
					
					check[str.charAt(j)-'a'] = true;
					
				} else {//처음 나온 단어가 아니라면
					
					if(str.charAt(j) == str.charAt(j-1)) {
						
						continue;
						
					} else {
						
						visited = true;
						break;
						
					}
					
				}
			}
			if(!visited) answer++;
		}
		System.out.println(answer);
	}

}
