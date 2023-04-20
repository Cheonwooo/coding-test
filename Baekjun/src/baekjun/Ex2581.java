package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex2581 {
	static boolean[] prime; //false : 소수, true : 소수아님
	
	public static boolean[] make_prime(int num) {
		prime = new boolean[num+1];
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(prime[i]==true) {
				continue;
			}
			
			for(int j=i*i; j<num+1; j=j+i) {
				prime[j]=true;
			}
		}
		return prime;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		make_prime(n2);
		
		for(int i=n1; i<=n2; i++) {
			if(prime[i]==false) {
				sum += i;
				if(min==Integer.MAX_VALUE) {
					min = i;
				}
			}
		}
		if(sum==0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
		
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=n1; i<=n2; i++) {
			boolean prime = true; //소수일 경우 true, 소수가 아닐 경우 false
			
			if(i < 2) {
				continue;
			}
			
			for(int j=2; j<i;j++) {
				if(i%j==0) {
					prime = false;
					break;
				}
			}
			
			if(prime) {
				sum += i;
				if(min == Integer.MAX_VALUE) {
					min = i;
				}
			}
		}
		if(sum==0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}*/
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int sum = 0;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=n1; i<=n2; i++) {
			boolean prime = true;
			
			if(i==1) {
				continue;
			}
			
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					prime = false;
					break;
				}
			}
			if(prime) {
				sum += i;
				arr.add(i);
			}
		}
		if(sum==0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(arr.get(0));
		}*/
		
	}
}
