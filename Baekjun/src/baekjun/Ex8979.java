package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex8979 {

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] origin = new int[n];
		int[] sorted = new int[n];
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>(); 
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			sorted[i] += (Integer.parseInt(st.nextToken())*100 +
					Integer.parseInt(st.nextToken())*10 +
					Integer.parseInt(st.nextToken()));
			
			origin[i] = sorted[i];
		}
		
		Integer[] re_Rank = Arrays.stream(sorted).boxed().toArray(Integer[]::new);
		
		Arrays.sort(re_Rank, Collections.reverseOrder());
		
		int rank = 1;
		
		for(int v : re_Rank) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(i==k-1) {
				System.out.println(rankingMap.get(origin[i]));
			}
		}
	}

}
