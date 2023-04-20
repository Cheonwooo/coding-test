package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex9020 {
	
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
		//주어진 수의 make_prime 생성
		//주어진 수보다 작은 소술의 합으로 이루어짐
		//주어진 수 - 소수 = 소수일 경우 (단 빼는 수는 sqrt(num)이하 까지))
		//주어진 수 - 소수 = 작은 수로 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());

		for(int i=0; i<num; i++) {
			int n = Integer.parseInt(br.readLine());
			int min = 0;
			int max = Integer.MAX_VALUE; //두 수의 차를 구별할 변수
			
			make_prime(n);
			
			for(int j=2; j<=n/2; j++) {
				if(prime[j]==false && prime[n-j] == false) { //둘 다 false일 경우
					if(max==Integer.MAX_VALUE) {
						max = n-j;
						min = j;
					} else {
						max = (max < n-j) ? max : n-j;
						min = (min > j) ? min : j;
					}
				}
			}
			System.out.println(min + " " + max);
		}
	}
}
