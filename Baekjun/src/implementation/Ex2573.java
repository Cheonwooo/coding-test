package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex2573 {
	public static int n, m;
	public static int[][] arr;
	public static int[][][] ice;
	public static boolean[][] visited, check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Pair> q = new LinkedList<>();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0) {//빙산의 좌표값 저장
					q.add(new Pair(i, j));
					check[i][j] = true;
				}
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int year = 1;
		
		while(true) {
			
			visited = new boolean[n][m];//바로 삭제하기 때문에 0이 된 값을 포함할 수도 있으므로 false이면 포함
			ice = new int[n][m][1];
			while(!q.isEmpty()) {
				Pair cur = q.poll();
				int x = cur.x;
				int y = cur.y;
				
				for(int i=0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(arr[nx][ny]==0 && !visited[nx][ny]) {//동서남북 값이 0이라면
						ice[x][y][0]++;
					}
				}
				if(arr[x][y] - ice[x][y][0] <= 0) {
					visited[x][y] = true;//0으로 포함 안하게 true로 변경
					arr[x][y] = 0;
				} else {
					arr[x][y] -= ice[x][y][0];
				}
			}
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(dfs(i,j)) cnt++;
				}
			}
			
			if(cnt > 1) break;
			else if(cnt==1){
				check = new boolean[n][m];
				for(int i=0; i<n; i++) {
					for(int j=0; j<m; j++) {
						if(arr[i][j] != 0) {
							q.add(new Pair(i, j));
							check[i][j] = true;
						}
					}
				}
				year++;
			} else if(cnt==0) {
				year = 0;
				break;
			}
		}
		
		System.out.println(year);
	}

	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean dfs(int x, int y) {
		if(x<=-1 || x>=n || y<=-1 || y>=m) {
			return false;
		}
		
		if(arr[x][y] != 0 && check[x][y]) {
			check[x][y] = false;
			
			dfs(x-1, y);
			dfs(x, y-1);
			dfs(x+1, y);
			dfs(x, y+1);
			
			return true;
		}
		return false;
	}
}
