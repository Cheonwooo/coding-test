package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex19236 {
	
	public static class Shark implements Comparable<Shark>{
		int x;
		int y;
		int num;
		int dir;
		boolean exist;
		
		public Shark(int x, int y, int num, int dir, boolean exist) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.exist = exist;
		}

		public final int getX() {
			return x;
		}


		public final int getY() {
			return y;
		}


		public final int getNum() {
			return num;
		}

		public final int getDir() {
			return dir;
		}
		
		
		public final boolean isExist() {
			return exist;
		}

		public int compareTo(Shark o) {
			return this.num - o.num;
		}
	}

	public static int answer = 0;
	public static boolean check;
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	public static Shark[][] shark;
	public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		shark = new Shark[4][4];
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				
				shark[i][j] = new Shark(i, j, num, dir, false);
				
			}
		}
		int eat = shark[0][0].getNum();
		shark[0][0].num = 17;
		shark[0][0].exist = true;
		
		sharkMove(0, 0, eat);
		
		System.out.println(answer);
	}
	
	public static void fishMove() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(shark[i][j].getNum()!=0 && shark[i][j].getNum()!=17) {
					pq.offer(shark[i][j].getNum());
				}
			}
		}
		while(!pq.isEmpty()) {
			int now = pq.poll();
			
			int x = 0;
			int y = 0;
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					if(now == shark[i][j].getNum()) {
						x = i;
						y = j;
					}
				}
			}
			//잡아먹힌 물고기라면 패스
			if(x==0 && y==0) continue;
			else {
				int d = shark[x][y].getDir();
				
				while(true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					
					//상어가 있거나 경계를 넘어가는 경우 45도 회전
					if(nx>=0 && nx<4 && ny>=0 && ny<4 && !shark[nx][ny].isExist()) {
						shark[x][y].dir = d;
						swap(shark[x][y], shark[nx][ny]);
						break;
					} else {
						d++;
						if(d==8) d=0;
					}
					
				}
			}	
		}
	}
	
	public static void sharkMove(int x, int y, int max) {
		
		answer = Math.max(max, answer);
		
		Shark[][] tempShark = new Shark[4][4];
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				tempShark[i][j] = new Shark(shark[i][j].x, shark[i][j].y, shark[i][j].num, shark[i][j].dir, shark[i][j].exist);
			}
		}
		
		fishMove();
		
//		for(int i=0; i<4; i++) {
//			for(int j=0; j<4; j++) {
//				System.out.print(shark[i][j].getNum() + " " + shark[i][j].getDir()+"/");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		int d = shark[x][y].getDir();
		for(int i=1; i<4; i++) {
			int nx = x + dx[d]*i;
			int ny = y + dy[d]*i;
			
			
			if(nx>=0 && nx<4 && ny>=0 && ny<4 && shark[nx][ny].getNum()!=0) {
				int tempNum = shark[nx][ny].getNum();
				shark[x][y].num = 0;//상어가 있던 자리는 벽으로
				shark[x][y].exist = false;
				shark[nx][ny].num = 17;
				shark[nx][ny].exist = true;
				
				
				sharkMove(nx, ny, max+tempNum);
				
				shark[x][y].num = 17;
				shark[x][y].exist = true;
				shark[nx][ny].num = tempNum;
				shark[nx][ny].exist = false;
			}
			
		}
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				shark[i][j] = new Shark(tempShark[i][j].x, tempShark[i][j].y, tempShark[i][j].num, tempShark[i][j].dir, tempShark[i][j].exist);
			}
		}
	}
	
	public static void swap(Shark s1, Shark s2) {
		int tempX = s2.getX();
		int tempY = s2.getY();
		int tempNum = s2.getNum();
		int tempDir = s2.getDir();
		boolean tempExist = s2.isExist();
		
		s2.x = s1.x;
		s2.y = s1.y;
		s2.num = s1.num;
		s2.dir = s1.dir;
		s2.exist = s1.isExist();
		
		s1.x = tempX;
		s1.y = tempY;
		s1.num = tempNum;
		s1.dir = tempDir;
		s1.exist = tempExist;
	}
	
}
