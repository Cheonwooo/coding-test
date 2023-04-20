package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex13 {

	public static void main(String[] args) throws IOException {
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		
		while(true) {
		
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			sum = n + m;
			
			if(n==0 && m==0) break;
			else {
				bw.write(String.valueOf(sum));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();*/
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0 ;
		
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			sum = m + n;
			
			if(n==0 && m==0) break;
			else System.out.println(sum);
			
		}
		
		
		
		
	}

}
