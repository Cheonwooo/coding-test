package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex17143_3 {
	public static class Shark{
		int x;
		int y;
		int s;
		int d;
		int z;
		
		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static int r, c, m, sum;
	public static Shark[][] shark;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		shark = new Shark[r+1][c+2];

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			
			shark[x][y] = new Shark(x, y, s, d, z);
		}
		
		int hy = 0;
		sum = 0;
		
		while(true) {
			hy++;
			if(hy==c+1) break;
//			print();
			fishing(hy);
//			print();
			move();
//			print();
		}
		
		System.out.println(sum);
	}

	public static void fishing(int n) {
		for(int i=1; i<r+1; i++)
			if(shark[i][n] != null) {
				sum += shark[i][n].z;
				shark[i][n] = null;
				return;
			}
	}
	
	public static void move() {
		Shark[][] tempShark = new Shark[r+1][c+1];
		
		for(int i=1; i<r+1; i++) {
			for(int j=1; j<c+1; j++) {
				if(shark[i][j]==null) continue;
				else {
					int speed = 0;
					if(shark[i][j].d == 0 || shark[i][j].d == 1) {//위아래라면
						speed = shark[i][j].s % ((r-1)*2);
					} else {//왼오라면
						speed = shark[i][j].s % ((c-1)*2);
					}
					
					int x = shark[i][j].x;
					int y = shark[i][j].y;
					int nd = shark[i][j].d;
//					System.out.println(speed + " " + x + " " + y + " " + nd);
					for(int k=0; k<speed; k++) {
						
						int nx = x + dx[nd];
						int ny = y + dy[nd];
						
						if(nx<=0 || nx>r || ny<=0 || ny>c) {
							if(nd%2==0) {//nd가 짝수일 때
								nd+=1;
							} else {//nd가 홀수일 때
								nd = (nd+3)%4;
							}
							k--;
							continue;
						}
						x = nx;
						y = ny;
//						System.out.println("m : " + x+ " " + y);
					}
//					System.out.println("new : " + x + " " + y + " " + nd);
					if(tempShark[x][y]!=null && tempShark[x][y].z > shark[i][j].z) {
						continue;
					}
					tempShark[x][y] = new Shark(x, y, shark[i][j].s, nd, shark[i][j].z);
				}
			}
		}
		for(int i=1; i<r+1; i++) {
			shark[i] = Arrays.copyOf(tempShark[i], c+1);
		}
	}
	
	public static void print() {
		for(int i=1; i<r+1; i++) {
			for(int j=1; j<c+1; j++) {
				if(shark[i][j]==null) System.out.print(0);
				else System.out.print(shark[i][j].z);
			}
			System.out.println();
		}
		System.out.println();
	}
}
