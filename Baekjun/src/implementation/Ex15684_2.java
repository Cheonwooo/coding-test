package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15684_2 {
	public static int n, m, h, answer = Integer.MAX_VALUE;
	public static int[][] lad;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		lad = new int[h+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lad[a][b] = 1;
			lad[a][b+1] = 2;
		}
		
		for(int i=0; i<=3; i++) {
			perm(0, i);
		}
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
	
	public static void perm(int depth, int r) {
		if(depth==r) {
			
			for(int i=1; i<n+1; i++) {
				if(!check(1, i, i)) {
					return;
				}
			}
			answer = Math.min(answer, depth);
			return;
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<h+1; j++) {
				if(lad[j][i]==0 && lad[j][i+1]==0) {
					lad[j][i] = 1;
					lad[j][i+1] = 2;
					perm(depth+1, r);
					lad[j][i] = 0;
					lad[j][i+1] = 0;
				}
			}
		}
	}
	
	public static boolean check(int x, int y, int start) {
		
		for(int i=0; i<h; i++) {
			if(lad[x][y]==1) y++;
			else if(lad[x][y]==2) y--;
			x++;
		}
		
		if(y==start) return true;
		else return false;
		
	}
}
