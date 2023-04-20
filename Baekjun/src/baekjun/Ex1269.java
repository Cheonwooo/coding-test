package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex1269 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		StringTokenizer st3 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		HashMap<Long, Integer> map1 = new HashMap<Long, Integer>();
		HashMap<Long, Integer> map2 = new HashMap<Long, Integer>();
		int cnt = 0;
		int excnt = 0;
		
		for(int i=0; i<N; i++) {
			long num1 = Long.parseLong(st2.nextToken());
			map1.put(num1, 0);
		}
		for(int i=0; i<M; i++) {//map2에서 교집합(excnt)개수, 차집합(cnt)개수
			long num2 = Long.parseLong(st3.nextToken());
			map2.put(num2, 0);
			if(!map1.containsKey(num2)) {
				cnt++;
			} else {
				excnt++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		System.out.println(cnt+(map1.size()-excnt));
		
	}

}
