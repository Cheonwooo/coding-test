package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex16 {

	public static void main(String[] args) throws IOException{
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min = arr[0];
		int max = arr[0];
		
		for(int j=0; j<arr.length-1; j++) {
			min = (min>arr[j+1]) ? arr[j+1] : min;
			max = (max>arr[j+1]) ? max : arr[j+1];
		}
		
		System.out.print(min + " " + max);*/
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int min = arr[0];
		int max = arr[0];
		
		for(int j=0; j<arr.length-1; j++) {
			min = (min>arr[j+1]) ? arr[j+1] : min;
			max = (max>arr[j+1]) ? max : arr[j+1];
		}
		System.out.println(min + " " + max);
	}

}
