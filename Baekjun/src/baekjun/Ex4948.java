package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4948 {
	static boolean[] prime;
	
	public static boolean[] make_prime(int num) {
		prime = new boolean[num+1];
		
		prime[0]=prime[1]=true;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(prime[i]) continue;
			for(int j=i*i; j<num+1; j+=i) {
				prime[j]=true;
			}
		}
		return prime;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			
			if(n==0) break;
			
			make_prime(n*2);
			
			for(int i=n+1; i<=n*2; i++) {
				if(prime[i]==false) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
