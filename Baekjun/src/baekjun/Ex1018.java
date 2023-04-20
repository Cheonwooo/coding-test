package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1018 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][M];
		
		for(int i=0; i<N; i++) {
			char[] list = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = list[j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		
		int[] num = new int[(N-7)*(M-7)];
		int cnt = 0;
		
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {//시작점 생성
				//arr[i][j] = (1,1)이라면 (8,8)까지
				int count = 0;
				for(int k=i; k<i+8; k++) {
					for(int l=j; l<j+8; l++) {
						if(arr[0][0] == 'W') {//첫항이 W일 경우
							if(k%2==0 && l%2==0) { //짝짝일경우 첫항과 동일
								if(arr[k][l]!='W') {
									count++;
								}
							} else if(k%2!=0 && l%2!=0) { //홀홀일경우 첫항과 동일
								if(arr[k][l]!='W') {
									count++;
								}
							} else if(k%2==0 && l%2!=0) {//짝홀일경우 첫항과 반대
								if(arr[k][l]!='B') {
									count++;
								}
							} else {
								if(arr[k][l]!='B') {//홀짝일경우 첫항과 반대
									count++;
								}
							}
						} else {//첫항이 B일 경우
							if(k%2==0 && l%2==0) { //짝짝일경우 첫항과 동일
								if(arr[k][l]!='B') {
									count++;
								}
							} else if(k%2!=0 && l%2!=0) { //홀홀일경우 첫항과 동일
								if(arr[k][l]!='B') {
									count++;
								}
							} else if(k%2==0 && l%2!=0) {//짝홀일경우 첫항과 반대
								if(arr[k][l]!='W') {
									count++;
								}
							} else {
								if(arr[k][l]!='W') {//홀짝일경우 첫항과 반대
									count++;
								}
							}
						}
						
						
					}
				}
				num[cnt] = count;
				cnt++;
			}
		}
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		
	}

}
/*
 * for(int k=0; k<4; k++) {
					for(int l=0; l<4; l++) {
						if(arr[0][0]=='W') { //첫 항이 W일 경우 WBWBW순서인지 확인
							if(arr[i+2*k][j+2*l] != 'W') {
								count++;
							} else if(arr[i+2*k][j+2*l+1] != 'B') {
								count++;
							} else if(arr[i+2*k+1][j+2*l] != 'B') {
								count++;
							} else if(arr[i+2*k+1][j+2*l+1] != 'W') {
								count++;
							}
						} else if(arr[0][0] == 'B'){ //첫 항이 B일 경우
							if(arr[i+2*k][j+2*l] != 'B') {
								count++;
							} else if(arr[i+2*k][j+2*l+1] != 'W') {
								count++;
							} else if(arr[i+2*k+1][j+2*l] != 'W') {
								count++;
							} else if(arr[i+2*k+1][j+2*l+1] != 'B') {
								count++;
							}
						}
					}
				}
				num[cnt] = count;
				cnt++;
				count=0;*/
