package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex7576 {
	public static int n,m;
	public static int[][] arr;
	public static Queue<Pair> q = new LinkedList<>();
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m][n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					q.add(new Pair(i,j));
				}
			}
		}
		System.out.println(tomato());
	}
	public static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int tomato(){
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			
			for(int i=0; i<4; i++) {
				int now_x = x+dx[i];
				int now_y = y+dy[i];
				
				if(now_x<=-1 || now_x>=m || now_y<=-1 || now_y>=n) {
					continue;
				}
				
				if(arr[now_x][now_y]==0) {
					arr[now_x][now_y] = arr[x][y]+1;
					q.add(new Pair(now_x, now_y));
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		if(check()) {//0이 하나라도 남아있을경우 -1
			return -1;
		} else {
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(max<arr[i][j]) {
						max = arr[i][j];
					}
				}
			}
			return max - 1;
		}
	}
	
	public static boolean check() {
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==0) {
					return true;//0이 하나라도 남아있다면 true
				}
			}
		}
		return false;//0이 하나라도 없다면 false
	}
	
	
}
