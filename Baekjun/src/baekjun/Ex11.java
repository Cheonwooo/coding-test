package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*import java.util.Scanner;*/

public class Ex11 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int n = Integer.parseInt(str);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<n; i++) {
			for(int j=n; j>i+1; j--) {
				bw.write(" ");
			}
			for(int k=0; k<i+1; k++) {
				bw.write("*");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
		/*Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=n; j>i+1; j--) {
				System.out.print(" ");
			}
			for(int k=0; k<i+1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}*/
	}

}
