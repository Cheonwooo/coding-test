package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex10816 {

	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; //초기값 0
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken()); 
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] list = new int[M];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			list[i] = Integer.parseInt(st2.nextToken());
			map.put(list[i], 0);
		}
		
		for(int i=0; i<N; i++) {
			if(map.containsKey(arr[i])) { //arr[i]를 가지고 있다면
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			sb.append(map.get(list[i])).append(' ');
		}
		System.out.println(sb);
	}
}
