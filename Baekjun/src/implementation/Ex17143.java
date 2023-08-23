package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex17143 {
	
	public static class Shark implements Comparable<Shark>{
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

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}

		public final int getS() {
			return s;
		}

		public final int getD() {
			return d;
		}

		public final int getZ() {
			return z;
		}
		
		public int compareTo(Shark other) {
			if(this.x == other.x && this.y == other.y) {
				return other.z - this.z;
			} else if(this.y == other.y) {
				return this.x - other.x;
			}
			return this.y - other.y;
		}
	}
	public static int sum, r, c;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int[][] map;
	public static ArrayList<Shark> list = new ArrayList<Shark>();
	public static ArrayList<Shark> temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[r+1][c+2];
		
		
		int hy = 0;
		map[0][hy] = 2;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			map[x][y] = z;
			
			list.add(new Shark(x, y, s, d, z));
		}
		
		sum = 0;
		while(true) {
			temp = new ArrayList<Shark>();
			Collections.sort(list);
			map[0][hy+1] = map[0][hy];
			hy++;
			if(map[0][c+1]==2) break;
			
			fishing(hy);//상어 잡기
			move();//상어 이동
			delete();//중복 상어 제거
			copy();
			
//			for(int i=1; i<r+1; i++) {
//				for(int j=1; j<c+1; j++) {
//					System.out.print(map[i][j]);
//				}System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(sum);
	}
	
	
	
	public static void delete() {
		
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		int size = temp.size();
		for(int i=0; i<size-1; i++) {
			int n1x = temp.get(i).getX();
			int n1y = temp.get(i).getY();
			int n2x = temp.get(i+1).getX();
			int n2y = temp.get(i+1).getY();
			
			if(n1x==n2x && n1y==n2y) {
				index.add(i+1);
//				System.out.println(n1x + " " + n2x + " " + n1y + " " +n2y + " " + (i+1));
			}
			
		}
		
		Collections.sort(index);
		size = index.size();
		for(int i=size-1; i>=0; i--) {
			int idx = index.get(i);
//			System.out.println(size + " " + idx);
			temp.remove(idx);
		}
	}
	
	public static void move() {
		int size = list.size();
		
		for(int i=0; i<size; i++) {
			int x = list.get(0).getX();
			int y = list.get(0).getY();
			int s = list.get(0).getS();
			int d = list.get(0).getD();
			int z = list.get(0).getZ();
			
//			System.out.println(x + " " + y +  " " + s + " " + d+ " " + z);
			for(int j=0; j<s; ) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
//				System.out.println(nx + " " + ny + " " + d);
				if(nx<=0 || nx>r || ny<=0 || ny>c) {
					if(d%2==0) {//d가 짝수면
						d+=1;
					} else {
						d+=3;
						d%=4;
					}
					
					continue;
				}
				
				x = nx;
				y = ny;
				j++;
			}
			
//			map[x][y] = Math.max(map[x][y], z);
			list.remove(0);
			temp.add(new Shark(x, y, s, d, z));
		}
	}
	
	public static void fishing(int humanY) {
		int len = list.size();
		for(int i=0; i<len; i++) {
			int size = list.get(i).getZ();
			int ny = list.get(i).getY();
			
//			System.out.println(size + " " + ny);
			if(humanY==ny) {
				sum += size;
				list.remove(i);
				break;
			}
		}
	}
	
	public static void copy() {
		for(int i=0; i<temp.size(); i++) {
			int nx = temp.get(i).getX();
			int ny = temp.get(i).getY();
			int ns = temp.get(i).getS();
			int nd = temp.get(i).getD();
			int nz = temp.get(i).getZ();

			list.add(new Shark(nx, ny, ns, nd, nz));
		}
		temp.clear();
	}

	public static void print() {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getX() + " " + list.get(i).getY() + " " + list.get(i).getS() + " " + list.get(i).getD() + " " + list.get(i).getZ());
		}
		System.out.println();
	}
}
