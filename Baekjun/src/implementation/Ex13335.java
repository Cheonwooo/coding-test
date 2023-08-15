package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex13335 {
	
	public static class Pair{
		int weight;
		int cnt;
		
		public Pair(int weight, int cnt) {
			this.cnt = cnt;
			this.weight = weight;
		}

		public final int getWeight() {
			return weight;
		}

		public final int getCnt() {
			return cnt;
		}
		
	}
	
	public static int n, w, l, sum;
	public static Queue<Pair> bridge = new LinkedList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		bridge.add(new Pair(arr[idx], w));
		idx++;
		int answer = 1;
		
		while(true) {
			answer++;
			//트럭들 먼저 보낸 후 무게 계산
			int size = bridge.size();
			
			for(int i=0; i<size; i++) {
				Pair update = bridge.poll();
				
				int weight = update.getWeight();
				int cnt = update.getCnt();
				
				if(cnt==1) continue;
				
				bridge.add(new Pair(weight, cnt-1));
				
			}
			if(idx!=n && check() && sum+arr[idx]<=l) {//다리 위 트럭들의 무게 합이 l보다 작은 경우
				
				int truck = arr[idx];
				idx++;
				bridge.add(new Pair(truck, w));
			}
			
			if(bridge.isEmpty()) break;
		}
		
		System.out.println(answer);
	}
	
	public static boolean check() {
		sum = 0;
		int size = bridge.size();
		
		if(size==0) return true;
		
		for(int i=0; i<size; i++) {
			Pair cur = bridge.poll();
			
			int weight = cur.getWeight();
			int cnt = cur.getCnt();
			sum += weight;
			bridge.add(new Pair(weight, cnt));
		}
		if(sum<=l) return true;
		else return false;
	}
}
