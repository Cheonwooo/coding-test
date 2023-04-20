package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1929 {
	static boolean[] prime;
	
	public static boolean[] make_prime(int num) {
		prime = new boolean[num+1];
		
		prime[0] = prime[1] = true;
		
		for(int i=2; i<=Math.sqrt(num);i++) {
			if(prime[i]==true) {
				continue;
			}
			
			for(int j=i*i; j<num+1; j+=i) {
				prime[j] = true;
			}
		}
		
		return prime;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		make_prime(n2);
		
		StringBuilder sb = new StringBuilder();
		for(int i=n1; i<=n2; i++) {
			if(prime[i]==false) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}

}
