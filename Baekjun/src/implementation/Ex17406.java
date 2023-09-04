package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17406 {
	public static class Pair{
		int r;
		int c;
		int s;
		
		public Pair(int r, int c ,int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		public final int getR() {
			return r;
		}

		public final void setR(int r) {
			this.r = r;
		}

		public final int getC() {
			return c;
		}

		public final void setC(int c) {
			this.c = c;
		}

		public final int getS() {
			return s;
		}

		public final void setS(int s) {
			this.s = s;
		}
		
	}
	public static int n, m, k, min;
	public static int[][] arr, temp;
	public static Pair[] pair;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		temp = new int[n+1][m+1];
		
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<m+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pair = new Pair[k];
		int[] output = new int[k];
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			pair[i] = new Pair(r, c, s);
		}
		
		
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<k; i++) {
			visited = new boolean[k];
			comb(output, i, 0, k);
		}
		
		System.out.println(min);
	}
	
	public static void comb(int[] output, int start, int depth, int r) {
		if(depth==r) {
			for(int i=1; i<n+1; i++) {//배열 초기화
				for(int j=1; j<m+1; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			
			turn(output);
			
			
			for(int i=1; i<n+1; i++) {
				int sum = 0;
				for(int j=1; j<m+1; j++) {
					sum += temp[i][j];
				}
				
				min = Math.min(min, sum);
			}
//			System.out.println(min);
			return;
		}
		
		for(int i=start; i<k; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = i;
				comb(output, start, depth+1,  r);
				visited[i] = false;
			}				
		}
	}
	
	public static void turn(int[] output) {
		for(int i=0; i<k; i++) {
			Pair now = pair[output[i]];
			
			int nr = now.getR();
			int nc = now.getC();
			int S = now.getS();
			
			
			for(int ns=1; ns<=S; ns++){
				
				int tempA = temp[nr-ns][nc-ns];//처음값 저장
				//아래에서 위로
				for(int k=nr-ns; k<nr+ns; k++) {
					temp[k][nc-ns] = temp[k+1][nc-ns];
				}
				//오에서 왼으로
				for(int k=nc-ns; k<nc+ns; k++) {
					temp[nr+ns][k] = temp[nr+ns][k+1];
				}
				//위에서 아래로
				for(int k=nr+ns; k>nr-ns; k--) {
					temp[k][nc+ns] = temp[k-1][nc+ns];
				}
				//왼에서 오로
				for(int k=nc+ns; k>nc-ns; k--) {
					if(k==nc-ns+1) {
						temp[nr-ns][k] = tempA;
					} else {
						temp[nr-ns][k] = temp[nr-ns][k-1];
					}
				}
			}
			
//			for(int j=1; j<n+1; j++) {
//				for(int k=1; k<m+1; k++) {
//					System.out.print(temp[j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
	}

	
}
