package baekjun;
/*
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;*/
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex12 {

	public static void main(String[] args) {
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str1);
		int n = Integer.parseInt(st1.nextToken());
		int x = Integer.parseInt(st1.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String str2 = br.readLine();
		StringTokenizer st2 = new StringTokenizer(str2);
		
		while(st2.hasMoreTokens()) {
			list.add(Integer.parseInt(st2.nextToken()));
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int j=0; j<list.size(); j++) {
			if(list.get(j)<x) {
				bw.write(String.valueOf(list.get(j)) + " ");
			}
		}
		bw.flush();
		bw.close();*/
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int j=0; j<arr.length; j++) {
			if(arr[j]<x) {
				System.out.print(arr[j] + " ");
			}
		}
	}

}
