package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex17144 {
	public static class DustM{
		int x;
		int y;
		
		public DustM(int x, int y) {
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

	public static int r, c, t;
	public static int[][] map, dust;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static ArrayList<DustM> list = new ArrayList<DustM>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		dust = new int[r][c];
		
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dust[i][j] = map[i][j];
				if(map[i][j]==-1) {
					list.add(new DustM(i ,j));
				}
			}
		}
		while(t!=0) {
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					map[i][j] = dust[i][j];
				}
			}
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(map[i][j]!=0 && map[i][j]!=-1) {
						dustSpread(i, j);
					}
				}
			}
			dustMove();
//			for(int i=0; i<r; i++) {
//				for(int j=0; j<c; j++) {
//					System.out.print(dust[i][j] + " ");
//				}
//				System.out.println();
//			}
			t--;
		}
		
		System.out.println(check());
		
	}
	
	public static void dustSpread(int x, int y) {
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny]!=-1) {
				dust[nx][ny] += map[x][y]/5;
				dust[x][y] -= map[x][y]/5;
			}
		}
	}
	
	public static void dustMove() {
		for(int i=0; i<2; i++) {
			int x = list.get(i).getX();
			int y = list.get(i).getY();
			
			if(i==0) {
				for(int j=x-1; j>=0; j--) {
					if(j==0) break;
					else {
						dust[j][0] = dust[j-1][0];
					}
				}
				for(int j=0; j<c-1; j++) {
					dust[0][j] = dust[0][j+1];
				}
				for(int j=0; j<x; j++) {
					dust[j][c-1] = dust[j+1][c-1];
				}
				for(int j=c-1; j>=2; j--) {
					dust[x][j] = dust[x][j-1];
				}
				dust[x][1] = 0;
			} else {
				for(int j=x+1; j<r-1; j++) {
					dust[j][0] = dust[j+1][0];
				}
				for(int j=0; j<c-1; j++) {
					dust[r-1][j] = dust[r-1][j+1];
				}
				for(int j=r-1; j>x; j--) {
					dust[j][c-1] = dust[j-1][c-1];
				}
				for(int j=c-1; j>1; j--) {
					dust[x][j] = dust[x][j-1];
				}
				dust[x][1] = 0;
			}
		}
	}
	
	public static int check() {
		int answer = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(dust[i][j]!=0 && dust[i][j]!=-1) {
					answer += dust[i][j];
				}
			}
		}
		return answer;
	}

}
