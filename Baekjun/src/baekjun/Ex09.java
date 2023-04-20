package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex09 {

	public static void main(String[] args) throws IOException {
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int n = Integer.parseInt(str);
		int sum = 0;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=1; i<n+1; i++) {
			String num = br.readLine();
			StringTokenizer st = new StringTokenizer(num);
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			sum =  num1 + num2;
			bw.write("Case #" + i + ": " + sum + "\n");
		}
		bw.flush();
		bw.close();*/
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
		for(int i=1; i<n+1; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			sum = num1 + num2;
			
			System.out.println("Case #" + i + ": " + sum);
		}
	}

}
