package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2839 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		while(true) {
			if(n%5==0) {
				System.out.println(n/5);
				break;
			} else {//n%5!=0
				int x = n/5;
				int answer = 0;
				boolean check = false;
				while(x!=-1) {
					int num = n-(5*x);
					if(num%3==0) {
						check = true;
						answer = x + num/3;
						break;
					} else {//num%3!=0
						x--;
					}
				}
				if(!check) {
					System.out.println(-1);
					break;
				} else {
					System.out.println(answer);
					break;
				}
			}
		}
	}

}
