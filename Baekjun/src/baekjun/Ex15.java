package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) throws IOException{
		int count = 0;
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int num = Integer.parseInt(str);
		int copy = num;
		
		while(true) {
			num = ((num%10)*10) + (((num/10) + (num%10))%10);
			count++;
			
			if(copy==num) {
				break;
			}
		}
		System.out.println(count);*/
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int copy = num;
		
		while(true) {
			num = ((num%10)*10) + (((num/10) + (num%10))%10);
			count++;
			
			if(copy==num) break;
		}
		System.out.println(count);
	}
}
