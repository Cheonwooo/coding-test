package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12100 {
	public static int n, max;
	public static int[] output = new int[5];
	public static int[] dir = {0, 1, 2, 3};//북, 동, 남, 서
	public static int[][] arr, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		temp = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				temp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		max = Integer.MIN_VALUE;
		
		perm(0, 5);
		
		System.out.println(max);
	}
	
	public static void perm(int depth, int r) {//중복 순열의 수
		
		if(depth==r) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = temp[i][j];
				
				}
			}
			game(output);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					max = Math.max(max, arr[i][j]);
				}
			}
			
			return;
		}
		for(int i=0; i<4; i++) {
			output[depth] = dir[i];
			perm(depth+1, r);
		}
	}
	
	public static void game(int[] output) {
		
		for(int i=0; i<output.length; i++) {
			move(output[i]);
			if(output[i]==0) {
				for(int j=0; j<n; j++) {//열
					for(int k=1; k<n; k++) {//행
						if(arr[k-1][j]==arr[k][j]) {
							arr[k-1][j] *= 2;
							arr[k][j] = 0;
						}
					}
				}
			} else if(output[i]==1) {
				for(int j=0; j<n; j++) {//행
					for(int k=n-2; k>=0; k--) {
						if(arr[j][k+1]==arr[j][k]) {
							arr[j][k+1] *= 2;
							arr[j][k] = 0;
						}
					}
				}
			} else if(output[i]==2) {
				for(int j=0; j<n; j++) {//열
					for(int k=n-2; k>=0; k--) {
						if(arr[k+1][j] == arr[k][j]) {
							arr[k+1][j] *= 2;
							arr[k][j] = 0;
						}
					}
				}
			} else if(output[i]==3) {
				for(int j=0; j<n; j++) {//행
					for(int k=1; k<n; k++) {
						if(arr[j][k-1] == arr[j][k]) {
							arr[j][k-1] *= 2;
							arr[j][k] = 0;
						}
					}
				}
			}
//			for(int j=0; j<n; j++) {
//				for(int k=0; k<n; k++) {
//					System.out.print(arr[j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			move(output[i]);
			
//			for(int j=0; j<n; j++) {
//				for(int k=0; k<n; k++) {
//					System.out.print(arr[j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
	}
	
	public static void move(int x) {
		
		if(x==0) {
			for(int i=0; i<n; i++) {//열
				for(int j=1; j<n; j++) {//행
					if(arr[j][i]==0) continue;
					for(int l=j; l>=1; l--) {
						if(arr[l-1][i]==0) {
							arr[l-1][i] = arr[l][i];
							arr[l][i] = 0;
						}
					}
				}
			}
		} else if(x==1) {
			for(int i=0; i<n; i++) {//행
				for(int j=n-2; j>=0; j--) {//열
					if(arr[i][j]==0) continue;
					for(int l=j; l<n-1; l++) {
						if(arr[i][l+1]==0) {
							arr[i][l+1] = arr[i][l];
							arr[i][l] = 0;
						}
					}
				}
			}
		} else if(x==2) {
			for(int i=0; i<n; i++) {//열
				for(int j=n-2; j>=0; j--) {//행
					if(arr[j][i]==0) continue;
					for(int l=j; l<n-1; l++) {
						if(arr[l+1][i]==0) {
							arr[l+1][i] = arr[l][i];
							arr[l][i] = 0;
						}
					}
				}
			}
		} else if(x==3) {
			for(int i=0; i<n; i++) {//행
				for(int j=1; j<n; j++) {//열
					if(arr[i][j]==0) continue;
					for(int l=j; l>=1; l--) {
						if(arr[i][l-1]==0) {
							arr[i][l-1] = arr[i][l];
							arr[i][l] = 0;
						}
					}
				}
			}
		}
	}
}
