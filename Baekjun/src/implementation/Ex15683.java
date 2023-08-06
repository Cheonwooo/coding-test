package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex15683 {
	
	public static class Pair{
		int var;
		int x;
		int y;
		
		public Pair(int var, int x, int y) {
			this.var = var;
			this.x = x;
			this.y = y;
		}

		public final int getVar() {
			return var;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}
	}
	
	public static int n, m;
	public static int min = Integer.MAX_VALUE;
	public static int[][] arr, temp;
	public static boolean[] visited;
	public static int[] d;
	public static ArrayList<Pair> list = new ArrayList<Pair>();
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		temp = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]!=0 && arr[i][j]!=6) {
					list.add(new Pair(arr[i][j], i, j));
				}
			}
		}
		d = new int[list.size()];
		visited = new boolean[list.size()];
		
		perm(0);
		
		System.out.println(min);
	}
	
	public static void cctv(int[] d) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getVar()==1) {
				int x = list.get(i).getX();
				int y = list.get(i).getY();
				while(true) {		
					int nx = x + dx[d[i]];
					int ny = y + dy[d[i]];
					
					if(nx<0 || nx>=n || ny<0 || ny>=m || temp[nx][ny]==6) break;
					if(temp[nx][ny]!=6) {
						temp[nx][ny] = 9;//#대신 9
						
						x = nx;
						y = ny;
					}
				}
			} else if(list.get(i).getVar()==2) {
				int x = list.get(i).getX();
				int y = list.get(i).getY();
				
				int tempX = x;
				int tempY = y;
				
				if(d[i]==0 || d[i]==2) {//남북
					
					for(int j=0; j<4; j++) {
						x = tempX;
						if(j%2!=0) continue;
						else {
							while(true) {
								int nx = x + dx[j];
								int ny = y + dy[j];
								
								if(nx<0 || nx>=n || temp[nx][ny]==6) break;
								if(temp[nx][ny]!=6)
									temp[nx][ny] = 9;
								
									x = nx;
									y = ny;
							}
						}
					}
				} else {//동서
					for(int j=0; j<4; j++) {
						y = tempY;
						if(j%2==0) continue;
						else {
							while(true) {
								int nx = x + dx[j];
								int ny = y + dy[j];
								
								if(ny<0 || ny>=m || temp[nx][ny]==6)break;
								if(temp[nx][ny]!=6) {
									temp[nx][ny] = 9;
									
									x = nx;
									y = ny;
								}
							}
						}
					}
				}
			} else if(list.get(i).getVar()==3) {
				int x = list.get(i).getX();
				int y = list.get(i).getY();
				int tempX = x;
				int tempY = y;
				
				for(int j=0; j<2; j++) {
					x = tempX;
					y = tempY;
					
					int dir = d[i]+j;
					if(dir==4) dir = 0;
					while(true) {
						int nx = x + dx[dir];
						int ny = y + dy[dir];
						
						if(nx<0 || nx>=n || ny<0 || ny>=m || temp[nx][ny]==6) break;
						if(temp[nx][ny]!=6) {
							temp[nx][ny] = 9;
							
							x = nx;
							y = ny;
						}
					}
					
				}
				
			} else if(list.get(i).getVar()==4) {
				int x = list.get(i).getX();
				int y = list.get(i).getY();
				
				int tempX = x;
				int tempY = y;
				
				for(int j=0; j<3; j++) {
					 int dir = d[i]+j;
					 if(dir>=4) dir %= 4;
					 
					 x = tempX;
					 y = tempY;
					 
					 while(true) {
						 int nx = x + dx[dir];
						 int ny = y + dy[dir];
						 
						 if(nx<0 || nx>=n || ny<0 || ny>=m || temp[nx][ny]==6) break;
						 if(temp[nx][ny]!=6) {
							 temp[nx][ny] = 9;
							 
							 x = nx;
							 y = ny;
						 }
					 }
				}
			} else {//list.get(i).getVar()==5
				int x = list.get(i).getX();
				int y = list.get(i).getY();
				
				int tempX = x;
				int tempY = y;
				
				for(int j=0; j<4; j++) {
					x = tempX;
					y = tempY;
					while(true) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						
						if(nx<0 || nx>=n || ny<0 || ny>=m || temp[nx][ny]==6) break;
						if(temp[nx][ny]!=6) {
							temp[nx][ny] = 9;
							
							x = nx;
							y = ny;
						}
					}
				}
			}
		}
		//0개수 최솟값 확인
		min = Math.min(min, check());
	}
	
	public static void perm(int depth) {
		
		if(depth == list.size()) {
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			cctv(d);
//			for(int i=0; i<d.length; i++) {
//				System.out.print(d[i] + " ");
//			}
//			System.out.println();
			return;
		}
		
		for(int i=0; i<4; i++) {
			d[depth] = i;
			perm(depth + 1);
		}
	}

	public static int check() {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j]==0) cnt++;
			}
		}
		return cnt;
	}
}
