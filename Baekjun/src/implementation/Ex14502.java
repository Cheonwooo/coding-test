package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14502 {
	public static int n, m, result;
	public static int[][] arr, save_arr;
	public static int max = Integer.MIN_VALUE;
	
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		save_arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		virus(0);
		
		System.out.println(result);
	}

	public static void virus(int count) {
		if(count == 3) {//벽이 다 세워졌다면
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					save_arr[i][j] = arr[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(save_arr[i][j]==2) {
						dfs(i, j);
					}
				}
			}
			result = Math.max(result, check());
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==0) {
					arr[i][j]=1;
					count+=1;
					virus(count);
					arr[i][j]=0;
					count-=1;
				}
			}
		}
		
		
	}
	
	public static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<m) {
				if(save_arr[nx][ny]==0) {
					save_arr[nx][ny]=2;
					dfs(nx, ny);
				}
			}
		}
	}
	
	public static int check() {
		
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(save_arr[i][j]==0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
