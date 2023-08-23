package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 큐가 정렬되지않음
 */
public class Ex17143_2 {
	
	public static class Shark implements Comparable<Shark>{
		int x;
		int y;
		int speed;
		int dir;
		int size;
		
		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}

		public final int getSpeed() {
			return speed;
		}

		public final int getDir() {
			return dir;
		}

		public final int getSize() {
			return size;
		}
		
		public int compareTo(Shark other) {
			if(this.x == other.x && this.y == other.y) {
				return other.size - this.size;
			} else if(this.y == other.y) {
				return this.x - other.x;
			}
			return this.y - other.y;
		}
		
	}
	public static int r, c, m, sum;
	public static Shark[] shark;
	public static int[] dx = {-1, 1, 0 ,0};
	public static int[] dy = {0, 0, 1, -1};
	public static int[][] map, temp;
	public static PriorityQueue<Shark> q1 = new PriorityQueue<>();
	public static PriorityQueue<Shark> q2;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[r+1][c+2];
		temp = new int[r+1][c+2];
		shark = new Shark[m];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			shark[i] = new Shark(x, y, s, d, z);
			q1.add(new Shark(x, y, s, d, z));
			map[x][y] = z;
		}
		
		int hy = 0;//사람의 처음 위치
		sum = 0;
		while(true) {
			hy++;
			if(hy==7) break;
			q2 = new PriorityQueue<>();
			print();
			fishing(hy);//q2에 상어 채워지고, q1은 비어있는 상태
			move();
			print();
			delete();
		}
		System.out.println(sum);
	}
	
	public static void fishing(int n) {
		
		boolean check = false;
		while(!q1.isEmpty()) {
			Shark now = q1.poll();
			
			int nx = now.x;
			int ny = now.y;
			int nspeed = now.speed;
			int ndir = now.dir;
			int nsize = now.size;
			
			if(n == ny && !check) {//낙시왕이 있는 열에 있는 첫번째 상어
				System.out.println(nsize);
				System.out.println(n);
				sum += nsize;
				check = true;
			} else {
				q2.add(new Shark(nx, ny, nspeed, ndir, nsize));
			}
		}
	}
	
	public static void move() {
		while(!q2.isEmpty()) {
			Shark now = q2.poll();
			
			int nx = now.x;
			int ny = now.y;
			int nspeed = now.speed;
			int ndir = now.dir;
			int nsize = now.size;
			
			for(int i=0; i<nspeed; i++) {
				int sx = nx + dx[ndir];
				int sy = ny + dy[ndir];
				
				if(sx<=0 || sx>r || sy<=0 || sy>c) {
					if(ndir%2==0) {//ndir이 짝수라면
						ndir += 1;
					} else {//ndir이 홀수라면
						ndir += 3;
						ndir %= 4;
					}
					i--;
					continue;
				}
				nx = sx;
				ny = sy;
			}
			
			q1.add(new Shark(nx, ny, nspeed, ndir, nsize));
		}
	}
	
	public static void delete() {
		int size = q1.size();
		int nx = 0;
		int ny = 0;
		for(int i=0; i<size; i++) {
			Shark now = q1.poll();
			
			if(nx == now.x && ny == now.y) {//두 좌표가 같을 때 패스
				System.out.println(now.x + " " +now.y + " " + now.size);
				continue;
			}
			if(nx != now.x || ny != now.y) {//둘 중 하나라도 다르다면
				nx = now.x;
				ny = now.y;
				int nspeed = now.speed;
				int ndir = now.dir;
				int nsize = now.size;
				
				q2.add(new Shark(nx, ny, nspeed, ndir, nsize));
			}			
		}
		
		while(!q2.isEmpty()) {
			Shark now = q2.poll();
			
			nx = now.x;
			ny = now.y;
			int nspeed = now.speed;
			int ndir = now.dir;
			int nsize = now.size;
			
			q1.add(new Shark(nx, ny, nspeed, ndir, nsize));
		}
	}
	
	public static void print() {
		while(!q1.isEmpty()) {
			Shark now = q1.poll();
			
			int nx = now.x;
			int ny = now.y;
			int nspeed = now.speed;
			int ndir = now.dir;
			int nsize = now.size;
			
			System.out.println(nx + " " + ny + " " + nspeed + " " + ndir + " " + nsize);
			
			q2.add(new Shark(nx, ny, nspeed, ndir, nsize));
		}
		
		while(!q2.isEmpty()) {
			Shark now = q2.poll();
			
			int nx = now.x;
			int ny = now.y;
			int nspeed = now.speed;
			int ndir = now.dir;
			int nsize = now.size;
			
			q1.add(new Shark(nx, ny, nspeed, ndir, nsize));
		}
		System.out.println();
	}
}
