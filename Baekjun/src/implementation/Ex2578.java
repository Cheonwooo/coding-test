package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2578 {
	public static int cnt, ans;
	public static int[][] bingo;
	public static boolean[][] answer;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		bingo = new int[5][5];
		answer = new boolean[5][5];
		
		StringTokenizer st;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				ans++;
				
				bingo(num);
				
				check();
				if(cnt>=3) {
					break;
				}
					
			}
			if(cnt>=3) break;
		}
		System.out.println(ans);
	}
	public static void bingo(int n) {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(bingo[i][j]==n) {
					answer[i][j] = true;
				}
			}
		}
	}

	public static void check() {
		cnt=0;
		//행체크
		//열체크
		//대각선체크
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(!answer[i][j]) {
					break;
				}
				if(j==4) cnt++;
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(!answer[j][i]) {
					break;
				}
				if(j==4) cnt++;
			}
		}
		
		for(int i=0; i<5; i++) {
			if(!answer[i][i]) {
				break;
			}
			if(i==4) cnt++;
		}
		
		for(int i=0; i<5; i++) {
			if(!answer[4-i][i]) {
				break;
			}
			if(i==4) cnt++;
		}
	}
}
