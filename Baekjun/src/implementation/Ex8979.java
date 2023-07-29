package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex8979 {
	
	public static class Olympic implements Comparable<Olympic>{
		int num;
		int g;
		int s;
		int b;
		
		public Olympic(int num, int g, int s, int b) {
			this.num = num;
			this.g = g;
			this.s = s;
			this.b = b;
		}

		public final int getNum() {
			return num;
		}

		public final int getG() {
			return g;
		}

		public final int getS() {
			return s;
		}

		public final int getB() {
			return b;
		}
		
		public int compareTo(Olympic other) {
			if(this.g == other.g && this.s == other.s) {
				return other.b - this.b;
			} else if(this.g == other.g) {
				return other.s - this.s;
			} else {
				return other.g - this.g;
			}
		}
	}
	
	public static PriorityQueue<Olympic> pq = new PriorityQueue<Olympic>();
	public static int n, k;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int seq = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			pq.offer(new Olympic(seq, gold, silver, bronze));
		}
		
		int rank = 1;
		int cnt = 1;
		Olympic now = pq.poll();
		int seq = now.getNum();
		int gold = now.getG();
		int silver = now.getS();
		int bronze = now.getB();
		
		if(seq==k) {
			System.out.println(rank);
		} else {
			while(!pq.isEmpty()) {
				now = pq.poll();
				int nq = now.getNum();
				int ng = now.getG();
				int ns = now.getS();
				int nb = now.getB();
				if(gold!=ng || silver!=ns || bronze!=nb) {
					gold=ng;
					silver=ns;
					bronze=nb;
					rank += cnt;
					cnt = 1;
				} else {
					cnt++;
				}
				if(nq==k) {
					break;
				}
			}
			System.out.println(rank);
		}
	}
}

