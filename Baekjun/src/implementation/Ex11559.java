package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ex11559 {
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
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
	
	public static int breaking;
	public static boolean[][] visited;
	public static int[][] arr;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[12][6];
		
		for(int i=0; i<12; i++) {
			String[] str = br.readLine().split("");
			
			for(int j=0; j<6; j++) {
				String bull = str[j];
				if(bull.equals(".")) {
					arr[i][j] = 0;
				} else if(bull.equals("R")) {
					arr[i][j] = 1;
				} else if(bull.equals("G")) {
					arr[i][j] = 2;
				} else if(bull.equals("B")) {
					arr[i][j] = 3;
				} else if(bull.equals("P")) {
					arr[i][j] = 4;
				} else if(bull.equals("Y")) {
					arr[i][j] = 5;
				}
			}
		}
		
		int answer = 0;
		
		while(true) {
			breaking = 0;
			visited = new boolean[12][6];
			
			for(int i=0; i<12; i++) {
				for(int j=0; j<6; j++) {
					if(!visited[i][j] && arr[i][j]!=0) {
//						System.out.println("answer : " + answer + " " + i + " " + j);
						bfs(arr[i][j], i, j);
					}
				}
			}
			if(breaking==0) break;
			answer += 1;
//			for(int i=0; i<12; i++) {
//				for(int j=0; j<6; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}System.out.println();
			move();
			
//			for(int i=0; i<12; i++) {
//				for(int j=0; j<6; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}System.out.println();
		}
		
		System.out.println(answer);
	}
	
	public static void bfs(int str, int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		Queue<Pair> pair = new LinkedList<>();
		
		q.offer(new Pair(x, y));
		pair.offer(new Pair(x, y));
		visited[x][y] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			int cx = cur.getX();
			int cy = cur.getY();
			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				
				if(nx<0 || nx>=12 || ny<0 || ny>=6 || visited[nx][ny]) continue;
				if(!visited[nx][ny] && arr[nx][ny] == str) {
					visited[nx][ny] = true;
					arr[nx][ny] = 0;
					cnt++;
					
					q.offer(new Pair(nx, ny));
					pair.offer(new Pair(nx, ny));
				}
			}
		}
//		System.out.println(str + " " + cnt);
		if(cnt>=4) {
			breaking++;
			while(!pair.isEmpty()) {
				Pair cur = pair.poll();
				
				arr[cur.getX()][cur.getY()]=0;
//				System.out.println("A" + " " + cur.getX() + " " + cur.getY());
			}
		} else {
			while(!pair.isEmpty()) {
				Pair cur = pair.poll();
				
				arr[cur.getX()][cur.getY()] = str;
			}
		}
//		for(int i=0; i<12; i++) {
//			for(int j=0; j<6; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}System.out.println();
	}
	
	public static void move() {
		for(int i=0; i<6; i++) {
			for(int j=11; j>0; j--) {
				if(arr[j][i] == 0) {
					for(int k=j-1; k>=0; k--) {
						if(arr[k][i]!=0) {
							arr[j][i] = arr[k][i];
							arr[k][i] = 0;
							break;
						}
					}
				}
			}
		}
		
	}
}

/*
......
......
......
......
......
......
......
......
......
......
RR.GG.
RR.GG.
*/
