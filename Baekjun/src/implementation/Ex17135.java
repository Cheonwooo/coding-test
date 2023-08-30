package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex17135 {
	public static class Archer{
		int x;
		int y;
		
		public Archer(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}
		
	}
	
	public static int n, m, d, max;
	public static int[][] arr, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m];
		temp = new int[n+1][m];
		boolean[] visited = new boolean[15];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = Integer.MIN_VALUE;
		comb(visited, 0, 3);
		
		System.out.println(max);
	}

	public static void comb(boolean[] visited, int start, int r) {
		if(r==0) {
			ArrayList<Archer> archer = new ArrayList<Archer>();
			
			for(int i=0; i<n+1; i++) {
				for(int j=0; j<m; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			
			for(int i=0; i<m; i++) {
				if(visited[i]) {
					archer.add(new Archer(n, i));
				}
			}
			
			max = Math.max(game(archer), max);
			return;
		}
		
		for(int i=start; i<m; i++) {
			visited[i] = true;
			comb(visited, i+1, r-1);
			visited[i] = false;
		}
	}
	
	public static int game(ArrayList<Archer> list) {
		int cnt = 0;
		int time = n;
		
		while(time>0) {
			time--;
			boolean[][] enemy = new boolean[n][m];
			
			int mx = 0;
			int my = 0;
			//한칸 아래로 내리는 로직 - ok
			//거리를 구해서 가장 가까운(왼쪽)을 잡는 로직
			for(int i=0; i<3; i++) {
				Archer now = list.get(i);
				
				int nx = now.getX();
				int ny = now.getY();
				
				mx = Integer.MAX_VALUE;
				my = Integer.MAX_VALUE;
				int min = Integer.MAX_VALUE;
				for(int j=0; j<m; j++) {
					for(int k=n-1; k>=0; k--) {
						int dist = (int)Math.abs(nx-k) + (int)Math.abs(ny-j);
						
						if(temp[k][j] == 1 && dist<=d && dist<min) {
							min = dist;
							mx = k;
							my = j;
						}
					}
				}
				if(mx==Integer.MAX_VALUE && my==Integer.MAX_VALUE) continue;
				enemy[mx][my] = true;
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(enemy[i][j]) {
						cnt++;
						temp[i][j] = 0;
//						System.out.println(cnt);
					}
				}
			}
			
			move();

		}
//		System.out.println("answer : " + cnt);
		return cnt;
	}
	
	public static void move() {
		for(int i=0; i<m; i++) {
			for(int j=n-1; j>=0; j--) {	
				if(j==0) temp[j][i] = 0;
				else temp[j][i] = temp[j-1][i];
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(temp[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}
}
