package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1202 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arrMK = new int[n][2]; // [][0] = M, [][1] = K
		ArrayList<Integer> arrC = new ArrayList<Integer>();
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arrMK[i][0] = Integer.parseInt(st.nextToken());
			arrMK[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<k; i++) {
			arrC.add(Integer.parseInt(br.readLine()));
		}
		
		Arrays.sort(arrMK, (o1, o2) -> {
			if(o1[0]==o2[0]) { //무게가 같다면
				return o2[1]-o1[1]; //가격은 내림차순 정렬
			} else { //무게가 같지 않다면 오름차순 정렬
				return o1[0] - o2[0];
			}
		}); //[][1] 기준 내림차순 정렬
	
		Collections.sort(arrC); //오름차순 정렬
		
		//가격 내림차순 정렬할 pq
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		long sum = 0;
		int index = 0;
		for(int i=0; i<k; i++) {
			while(index<n) {
				if(arrC.get(i) >= arrMK[index][0]) {
					pq.offer(arrMK[index][1]);
					index++;
				} else {
					break;
				}
			}
			
			if(!pq.isEmpty()) {
				System.out.println(pq.peek());
				sum += pq.poll();
			}
			
			
		}
		
		System.out.println(sum);
	}

}
