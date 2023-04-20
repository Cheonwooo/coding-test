package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex2667 {
	public static int n;
	public static int[][] arr;
	public static int sum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = (int)(str.charAt(j)-'0');
			}
		}
		sum = 0;
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(check(i, j)) {
					cnt++;
					list.add(sum);
					sum=0;
				}
			}
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		
		sb.append(cnt).append("\n");
		
		for(int v : list) {
			sb.append(v).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static boolean check(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=n) {
			return false;
		}
		if(arr[x][y]==1) {//방문하지 않은 노드라면
			sum += arr[x][y];
			arr[x][y]++;
			
			for(int k=0; k<n; k++) {
				for(int l=0; l<n;l++) {
					System.out.print(arr[k][l] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			check(x-1, y);
			check(x, y-1);
			check(x+1, y);
			check(x, y+1);
			
			return true;
		}
		
		return false;
	}
}
