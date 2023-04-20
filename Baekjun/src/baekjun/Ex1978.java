package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1978 {
	
	public static void main(String[] args) throws IOException{
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			boolean prime = true;
			
			int n = Integer.parseInt(st.nextToken());
			
			if(n==1) {
				continue;
			}
			for(int i=2; i<=Math.sqrt(n); i++) {
				if(n%i==0) {
					prime = false;
					break;
				}
			}
			if(prime) {
				count++;
			}
		}
		System.out.println(count);
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n1 = Integer.parseInt(br.readLine());
		int sum = 0;
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()){
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i=0; i<arr.size(); i++) {
			
			sum += make_prime(arr.get(i)); 
		}
		System.out.println(sum);
		
	}
	
	public static int make_prime(int number) {
		
		int count = 0;
		
		if(number < 2) {
			count = 0;
			return count;
		}
		
		if(number == 2) {
			count++;
			return count;
		}
		
		for(int i=2; i<number; i++) {
			if(number%i==0) {
				count=0;
				return count;
			}
		}
		count++;
		return count;*/
	}

}
