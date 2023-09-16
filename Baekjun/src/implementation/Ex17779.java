package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17779 {
	public static int n, sum, answer = Integer.MAX_VALUE;
	public static int[] num;
	public static int[][] map, vote;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<n; j++) {
				for(int p=1; p<n; p++) {
					for(int q=1; q<n; q++) {
						if(i+p+q>n || j-p<1 || j+q>n) continue;
						split(i, j, p, q);
//						System.out.println(1 + "<=" + i + "<" + (i+p+q) + "<=" + n + ", 1<=" + (j-p) + "<" + j + "<" + (j+q) + "<=" + n);
					}
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void split(int x, int y, int d1, int d2) {
		//경계선 먼저 넣고 num[][] == 5면 패스하기
		int all = n*n;
		vote = new int[n+1][n+1];
		
		num = new int[6];
		
		splitFive(x, y, d1, d2);
		splitAll(x, y, d1, d2);
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(vote[i][j]==0 || vote[i][j]==5) {
					num[5] += map[i][j];
				} else {
					num[vote[i][j]] += map[i][j];
				}
			}
		}
		
		for(int i=1; i<=5; i++) {
			max = Math.max(max, num[i]);
			min = Math.min(min, num[i]);
		}
		
		answer = Math.min(max-min, answer);
	}
	
	public static void splitFive(int x, int y, int d1, int d2) {
		int tempX = x;
		int tempY = y;
		while(true) {
			vote[tempX][tempY] = 5;
			if(tempX==x+d1 && tempY==y-d1) break;
			tempX += 1;
			tempY -= 1;
		}
		
		while(true) {
			vote[tempX][tempY] = 5;
			if(tempX==x+d1+d2 && tempY==y-d1+d2) {
				tempX = x;
				tempY = y;
				break;
			}
			tempX += 1;
			tempY += 1;
		}
		
		while(true) {
			vote[tempX][tempY] = 5;
			if(tempX==x+d2 && tempY==y+d2) break;
			tempX += 1;
			tempY += 1;
		}
		
		while(true) {
			vote[tempX][tempY] = 5;
			if(tempX==x+d2+d1 && tempY==y+d2-d1) break;
			tempX += 1;
			tempY -= 1;
		}
	}
	
	public static void splitAll(int x, int y, int d1, int d2) {
		//1번 선거구
		for(int i=1; i<x+d1; i++) {
			for(int j=1; j<=y; j++) {
				if(vote[i][j]==5) break;
				vote[i][j] = 1;
			}
		}
		
		//2번 선거구
		for(int i=1; i<=x+d2; i++) {
			for(int j=n; j>y; j--) {
				if(vote[i][j]==5) break;
				vote[i][j] = 2;
			}
		}
		
		//3번 선거구
		for(int i=x+d1; i<=n; i++) {
			for(int j=1; j<y-d1+d2; j++) {
				if(vote[i][j]==5) break;
				vote[i][j] = 3;
			}
		}
		
		//4번 선거구
		for(int i=x+d2+1; i<=n; i++) {
			for(int j=n; j>=y-d1+d2; j--) {
				if(vote[i][j]==5) break;
				vote[i][j] = 4;
			}
		}
	}
}
