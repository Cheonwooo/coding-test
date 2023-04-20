package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		
		
		while((str=br.readLine()) != null) {
			int a = str.charAt(0) - 48;
			int b = str.charAt(2) - 48;
			sb.append(a+b).append("\n");
		}
		System.out.print(sb);
		
		
		
		/*Scanner sc = new Scanner(System.in);
		
		int sum = 0 ;
		
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			sum = m + n;
			
			System.out.println(sum);
			
		}*/
	}

}
