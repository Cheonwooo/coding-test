package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Ex2108 {

	public static void main(String[] args) throws IOException{
		//산술평균 : 전체 합 / N개수 (float)
		//중앙값 : 올림차순 나열 후 중앙 값 (N/2번째)
		//최빈값 : counting 정렬 후 빈도 수 가장 높은 수
		//범위 : 최댓값 - 최솟값, N=1인 경우 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();//오름차순으로 정렬할 배열	
		boolean[] arr1 = new boolean[8001]; //int[4000]이 0, 오름차순 정렬에 사용할 배열
		int[] arr2 = new int[8001];//최빈값을 구할 배열
		int[] arr3 = new int[8001];
		
		//1 2 3 4 5 6 7 8 9 10  arr1
		//0 1 1 2 2 2 2 2 2 2   arr2
		
		//arr[1000] = 2, arr[1002] = 3, arr[1003] = 3
		
		int sum = 0;
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine())+4000;
			arr1[n] = true;
			arr2[n]++;
		}
		
		for(int i=0; i<8001; i++) {
			if(arr1[i]) {
				list.add(i-4000);
			}
		}
		
		for(int i=0; i<list.size(); i++) { //산술평균 구하기
			sum += list.get(i);
		}
		double cnt = sum/N;
		String avg = String.format("%.0f", cnt);
		sb.append(avg).append('\n');//산술평균
		sb.append(list.get(list.size()/2)).append('\n');//중앙값
		
		//최빈값은 arr2에서 최댓값 찾은 후 그 인덱스 값
		
		for(int i=1; i<8001; i++) {
			
		}

		int	size = list.get(list.size()-1) - list.get(0);
		sb.append(size).append('\n');//범위
		
		System.out.println(sb);
		
	}

}
