package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) throws IOException{
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> arr = new ArrayList<Integer>(9);
		
		for(int i=0; i<9; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		int max = arr.get(0);
		
		for(int j=0; j<8; j++) {
			max = (max>arr.get(j+1)) ? max : arr.get(j+1);
		}
		
		int num = arr.indexOf(max);
		
		System.out.println(max);
		System.out.println(num+1);*/
		
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		for(int i=0; i<9; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = arr[0];
		int num = 0;
		
		for(int j=0; j<8; j++) {
			max = (max>arr[j+1]) ? max : arr[j+1]; 
		}
		for(int k=0; k<9; k++) {
			if(arr[k]==max) {
				num = k;
				break;
			}
		}
		System.out.println(max);
		System.out.println(num+1);
		
	}

}
