package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex1065 {
	
	public static int check(int n) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int count = 0;
		if(n<100) {
			count = 1;
		} else {
			while(n!=0) { //각자리수를 구한 후 각 자리수의 차를 저장
				arr.add(n%10); //만약 123이라면 3 먼저
				n = n/10; //n에 12저장
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<arr.size()-1; i++) { //각 자리수의 차 저장
				list.add(arr.get(i+1)-arr.get(i)); 
			}
			for(int j=0; j<list.size()-1; j++) {
				if(list.get(j)==list.get(j+1)) {
					count = 1;
				} else {
					count = 0;
					break;
				}
			}
			
		}
		return count;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for(int i=1; i<n+1; i++) {
			sum += check(i);
		}
		
		System.out.println(sum);
		
	}

}
