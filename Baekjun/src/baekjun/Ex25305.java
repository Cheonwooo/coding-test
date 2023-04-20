package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex25305 {

	public static void main(String[] args) throws IOException{
		//내림차순 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		int[] cnt = new int[101];//점수를 저장할 배열
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			cnt[Integer.parseInt(st2.nextToken())]++;
		}
		
		for(int i=100; i>=0; i--) {
			while(cnt[i]>0) {
				arr.add(i);
				cnt[i]--;
			}
		}
		
		sb.append(arr.get(k-1));
		System.out.println(sb);
	}

}
