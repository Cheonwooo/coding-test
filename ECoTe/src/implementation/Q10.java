package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10 {
	public static int n, m;
	public static int[][] new_key, new_lock;
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int q = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		int[][] key = new int[q][q];
		int[][] lock = new int[p][p];
		
		StringTokenizer st;
		for(int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<q; j++) {
				key[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<p; j++) {
				lock[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(solution(key, lock)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public static boolean solution(int[][] key, int[][] lock) {
		boolean answer =false;
		n = key.length;
		m = lock.length;
		
		for(int r=0; r<4; r++) {
			new_key = new int[n][n];
			rotate(key, r);
			
			for(int i=0; i<lock.length+key.length-1; i++) {
				for(int j=0; j<lock.length+key.length-1; j++) {
					
					new_lock = new int[lock.length + (key.length-1)*2][lock.length + (key.length-1)*2];
					
					for(int k=0; k<m; k++) {
						for(int l=0; l<m; l++) {
							new_lock[n-1+k][n-1+l] = lock[k][l];
						}
					}
					
					for(int k=0; k<n ;k++) {
						for(int l=0; l<n; l++) {
							new_lock[i+k][j+l] += new_key[k][l];
						}
					}
					
					if(check()) {//키와 열쇠가 맞으면 true
						answer = true;
					}
				}
			}
		}
		return answer;
	}
	
	public static void rotate(int[][] key, int r) {
		if(r==0) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					new_key[i][j] = key[i][j];
				}
			}
		} else if(r==1) {//90도
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					new_key[i][j] = key[n-1-j][i];
				}
			}
		} else if(r==2) {//180도
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					new_key[i][j] = key[n-1-i][n-1-j];
				}
			}
		} else if(r==3) {//270도
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					new_key[i][j] = key[j][n-1-i];
				}
			}
		}
	}
	
	public static boolean check() {

		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				if(new_lock[n-1+i][n-1+j]!=1) {
					return false;
				}
			}
		}
		return true;
	}
}
