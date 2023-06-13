package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
	public static int r, max;
	public static String[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(gcd(162, 192));
	}
	
	public static int gcd(int a, int b) {
		if(a%b==0) {
			return b;
		} else {
			return gcd(b, a%b);
		}
	}
}
