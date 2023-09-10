package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17822 {
	public static int n, m;
	public static int[][] arr, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m];
		temp = new int[n+1][m];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			turn(x, d, k);//arr배열 회전
			
//			for(int p=1; p<n+1; p++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(arr[p][j] + " " );
//				}System.out.println();
//			}System.out.println();
			
			copy(arr, temp);//arr배열 temp배열에 복사
			if(check()) {//수가 남아있다면
				boolean exist = find();
				if(!exist) {//인접하면서 같은수가 하나도 없다면
					calc();
				}
			}
			copy(temp, arr);//temp배열을 arr배열로 복사
			
//			for(int p=1; p<n+1; p++) {
//				for(int j=0; j<m; j++) {
//					System.out.print(arr[p][j] + " " );
//				}System.out.println();
//			}System.out.println();
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<m; j++) {
				answer += arr[i][j];
			}
		}
		System.out.println(answer);
	}
	
	public static void turn(int x, int d, int k) {

		for(int i=1; i<n+1; i++) {
			if(i%x==0) {//i가 x의 배수라면 i번째 원판 회전
				for(int j=0; j<k; j++) {
					//k칸 회전
					if(d==0) {//시계방향일 때
						int temp = arr[i][m-1];
						for(int p=m-1; p>=0; p--) {
							if(p==0) {
								arr[i][p] = temp;
							} else {
								arr[i][p] = arr[i][p-1];
							}
							
						}
					}
					else {//반시계방향일 때
						int temp = arr[i][0];
						for(int p=0; p<m; p++) {
							if(p==m-1) {
								arr[i][p] = temp;
							} else {
								arr[i][p] = arr[i][p+1];
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean check() {
		boolean exist = false;
		
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j]!=0) exist = true;//수가 남아있다면
			}
		}
		
		return exist;
	}
	
	public static boolean find() {
		boolean exist = false;
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<m; j++) {//같은 원판 내에서 인접하면서 같은 수 찾기
				if(j==0 && arr[i][j]!=0) {
					if(arr[i][m-1] == arr[i][j]) {
						exist = true;
						temp[i][m-1] = 0;
						temp[i][j] = 0;
					}
					if(arr[i][j] == arr[i][j+1]) {
						exist = true;
						temp[i][j] = 0;
						temp[i][j+1] = 0;
					}
				} else if(j==m-1 && arr[i][j]!=0) {
					if(arr[i][j-1] == arr[i][j]) {
						exist = true;
						temp[i][j-1] = 0;
						temp[i][j] = 0;
					}
					if(arr[i][j] == arr[i][0]) {
						exist = true;
						temp[i][j] = 0;
						temp[i][0] = 0;
					}
				} else if(j>0 && j<m-1 && arr[i][j]!=0){
					if(arr[i][j-1] == arr[i][j]) {
						exist = true;
						temp[i][j-1] = 0;
						temp[i][j] = 0;
					}
					if(arr[i][j] == arr[i][j+1]) {
						exist = true;
						temp[i][j] = 0;
						temp[i][j+1] = 0;
					}
				}
			}
			
			//위아래 원판과 인접하면서 같은수 찾기
			for(int j=0; j<m; j++) {
				if(i==0 && arr[i][j]!=0) {//맨 위 원판이라면
					if(arr[i][j] == arr[i+1][j]) {
						exist = true;
						temp[i][j] = 0;
						temp[i+1][j] = 0;
					}
				} else if(i==n && arr[i][j]!=0) {//맨 아래 원판이라면
					if(arr[i][j] == arr[i-1][j]) {
						exist = true;
						temp[i][j] = 0;
						temp[i-1][j] = 0;
					}
				} else if(i>0 && i<n && arr[i][j]!=0){
					if(arr[i-1][j] == arr[i][j]) {
						exist = true;
						temp[i-1][j] = 0;
						temp[i][j] = 0;
					}
					if(arr[i][j] == arr[i+1][j]) {
						exist = true;
						temp[i][j] = 0;
						temp[i+1][j] = 0;
					}
				}
			}
		}
		return exist;
	}
	
	public static void calc() {
		double sum = 0;
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<m; j++) {
				sum += temp[i][j];
				if(temp[i][j]!=0) cnt++;
			}
		}
		
		double avg = sum/cnt;
		
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j]!=0) {
					if(temp[i][j] > avg) {
						temp[i][j] -= 1;
					} else if(temp[i][j] < avg) {
						temp[i][j] += 1;
					}
				}
			}
		}
		
	}
	
	public static void copy(int[][] arr1, int[][] arr2) {
		for(int i=1; i<n+1; i++) {
			for(int j=0; j<m; j++) {
				arr2[i][j] = arr1[i][j];
			}
		}
	}

}
