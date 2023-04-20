package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex11653 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int i = 2;
		
		if(num==1) {
			return;
		} else if(num==3) {
			System.out.println(3);
		} else {
			while(num!=1) {
				if(num%i==0) {//i로 나눴을때 나머지가 0인 경우
					System.out.println(i);
					num = num/i;
				} else if(num%i!=0) {
					i++;
				}
			}
		}
	}
}
