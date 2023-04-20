package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Ex2822 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] arr = new int[8];
		
		for(int i=0; i<8; i++) {
			int num = Integer.parseInt(br.readLine());
			
			map.put(num, i+1);
			arr[i] = num;
		}
		
		Integer[] sortArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(sortArr, Collections.reverseOrder());
		
		int sum = 0;
		int[] newArr = new int[5];
		
		for(int i=0; i<5; i++) {
			sum+=sortArr[i];
			newArr[i] = map.get(sortArr[i]);
		}
		
		Arrays.sort(newArr);
		
		System.out.println(sum);
		
		for(int i=0; i<5; i++) {
			System.out.print(newArr[i] + " ");
		}
	}
}
