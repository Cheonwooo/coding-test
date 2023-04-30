package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14500 {
	public static int n, m, sum;
	public static int[][] arr, new_arr;
	public static int max = Integer.MIN_VALUE;
	public static boolean[][] arr_tetro, new_check, new_arr_tetro;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];//기본배열
		new_arr = new int[n+6][m+6];//확장한 배열
		
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				new_arr[i+3][j+3] = arr[i][j]; 
			}
		}
		
		for(int k=0; k<n+3; k++) {
			for(int l=0; l<m+3; l++) {
				for(int i=1; i<6; i++) {
					tetromino(i);
					
					//회전 후 한칸씩 이동하면서 합 구하고 max값 구하기
						for(int r=0; r<4; r++) {
							
							turn(arr_tetro, new_arr_tetro, r);
							new_check = new boolean[n+6][m+6];//확장된 boolean배열
							
							for(int o=k; o<k+new_arr_tetro.length; o++) {
								for(int p=l; p<l+new_arr_tetro[0].length; p++) {
									new_check[o][p] = new_arr_tetro[o-k][p-l];
								}
							}
							
							//겹치는 부분의 arr_tetro가 ture라면 그 인덱스의 값을 sum에 더하기
							max = Math.max(max, check(new_check));
						}
						
				}
			}
		}
		System.out.println(max);
		
	}
	public static boolean[][] turn(boolean[][] arr, boolean[][] arr2, int r) {//시계방향으로 90도 회전
		new_arr_tetro = new boolean[4][4];
		
		if(r==0) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[i][j];
				}
			}
		} else if(r==1) { //90도
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[3-j][i];
				}
			}
		} else if(r==2) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[3-i][3-j];
				}
			}
		} else if(r==3) {
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					arr2[i][j] = arr[j][3-i];
				}
			}
		}
		
		return arr2;
	}
	
	
	public static void tetromino(int n) {//4x4배열 만든 후 1~5까지 숫자가 들어왔을 때 배열 초기화 및 값 배정
		//n값이 들어올 때 마다 arr배열 초기화
		arr_tetro = new boolean[4][4]; //tetro의 정보가 들어간 배열
		
		if(n==1) {//일자형
			for(int i=0; i<4; i++) {
				arr_tetro[0][i] = true;
			}
		} else if(n==2) {//정사각형
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					arr_tetro[i][j] = true;
				}
			}
		} else if(n==3) {//니은
			for(int i=0; i<3; i++) {
				arr_tetro[0][i] = true;
			}
			arr_tetro[1][0] = true;
		} else if(n==4) {//번개모양
			arr_tetro[0][0] = true;
			arr_tetro[1][0] = true;
			arr_tetro[1][1] = true;
			arr_tetro[2][1] = true;
		} else if(n==5) {//손가락 모양
			for(int i=0; i<3; i++) {
				arr_tetro[0][i] = true;
				arr_tetro[1][1] = true;
			}
		}
	}
	
	public static int check(boolean[][] arr) {//x,y는 new_arr의 크기
		int sum = 0;
		
		for(int i=0; i<n+6; i++) {
			for(int j=0; j<m+6; j++) {
				if(arr[i][j]) {//(i,j)가 true라면 sum에 더하기
					sum+=new_arr[i][j];
				}
			}
		}
		return sum;
	}
}
