package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1012 {
	public static int n,m;
	public static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		int[] earthworm = new int[t];
		
		
		
		for(int l=0; l<t; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			
			for(int i=0; i<n; i++) {//전부 0으로 초기화
				for(int j=0; j<m; j++) {
					arr[i][j]=0;
				}
			}
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
			}
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(check(i, j)) {
						cnt++;
					}
				}
			}
			earthworm[l] = cnt;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int v : earthworm) {
			sb.append(v).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean check(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=m) {
			return false;
		}
		if(arr[x][y]==1) {
			arr[x][y]=0;
			
			check(x-1, y);
			check(x, y-1);
			check(x+1, y);
			check(x, y+1);
			
			return true;
		}
		return false;
	}

}
