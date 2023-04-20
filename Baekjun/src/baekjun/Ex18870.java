package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] origin = new int[N];
		int[] sorted = new int[N];
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted);
		
		int rank = 0;
		for(int v : sorted) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int key : origin) {
			int num = rankingMap.get(key);
			sb.append(num).append(' ');
		}
		System.out.println(sb);
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		ArrayList<Long> list = new ArrayList<Long>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		for(int i=0; i<arr.length; i++) {// 중복 제거한 배열 list
			if(!list.contains(arr[i])) { //중복확인
				list.add(arr[i]);//없으면 list에 추가
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<arr.length; i++) {
			int cnt = 0;
			for(int j=0; j<list.size(); j++) {
				if(arr[i]>list.get(j)) {
					cnt++;
				}
			}
			sb.append(cnt).append(' ');
		}
		System.out.println(sb);*/
	}
	

}
