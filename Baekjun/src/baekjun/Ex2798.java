package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex2798 {
	
	static int search(int[] arr, int N, int M) {
		int result = 0;
		
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					
					if(sum == M ) {
						return sum;
					}
					
					if(sum<M && result<sum) {
						result = sum;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		int[] arr = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int result = search(arr, N, M);
		System.out.println(result);
		
		
		
		/*int sum;
		int max = 0;
		for(int i=0; i<N-2; i++) { //list에 3개의 수의 합 저장
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					sum = 0;
					sum = arr[i] + arr[j] + arr[k];
					if(sum <= M && max<sum) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);*/
		
		/*//방법2 : 
		int max = list.get(0);
		
		for(int i=1; i<list.size(); i++) {
			max = max > list.get(i) ? max : list.get(i);
		}
		
		System.out.println(max);*/
		
		//방법 1: 
		/*ArrayList<Integer> abs = new ArrayList<Integer>(); 
		
		for(int i=0; i<list.size(); i++) { //abs에 양수값만 저장
			if(M-list.get(i) > 0 || M-list.get(i) == 0) {
				abs.add(M-list.get(i));
			}
		}
		
		int min = abs.get(0);
		
		for(int i=1; i<abs.size(); i++) {
			if(min == abs.get(i)) {
				min = abs.get(i);
			} else {
				min = min < abs.get(i) ? min : abs.get(i);	
			}
		}
		
		System.out.println(M-min);*/
	}

}
