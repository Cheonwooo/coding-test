package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex20056 {
	public static class Shark{
		int r;
		int c;
		int m;
		int s;
		int d;
		
		public Shark(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		public final int getR() {
			return r;
		}

		public final int getC() {
			return c;
		}

		public final int getM() {
			return m;
		}

		public final int getS() {
			return s;
		}

		public final int getD() {
			return d;
		}
		
	}
	
	public static int n;
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	public static Queue<Shark>[][] shark;
	public static ArrayList<Shark> list;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Shark(r, c, m, s, d));
		}
		
		shark = new Queue[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				shark[i][j] = new LinkedList<>();
			}
		}
		
		while(k!=0) {
			move();
			fireball();
			k--;
		}
		
		int sum = 0;
		for(Shark f : list) {
			sum += f.m;
		}
		System.out.println(sum);
	}	
	public static void move() {
		for(Shark f : list) {
			f.r = (n+f.r+dx[f.d]*(f.s%n)) % n;
			f.c = (n+f.c+dy[f.d]*(f.s%n)) % n;
			
			shark[f.r][f.c].add(f);
		}
	}
	
	public static void fireball() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(shark[i][j].size()>=2) {
					int sumM = 0;
					int sumS = 0;
					int cnt = shark[i][j].size();
					boolean odd = true;//È¦¼ö
					boolean even = true;//Â¦¼ö
					
					while(!shark[i][j].isEmpty()) {
						Shark f = shark[i][j].poll();
						
						sumM += f.m;
						sumS += f.s;
						
						if(f.d%2 == 0) {//Â¦¼ö°¡ ÀÖ´Ù¸é ¸ðµÎ È¦¼ö°¡ ¾Æ´Ï¹Ç·Î
							odd = false;
						} else {
							even = false;
						}
						list.remove(f);
					}
					
					int nm = sumM/5;
					if(nm==0) {
						continue;
					}
					int ns = sumS/cnt;
					
					if(odd || even) {//µÑ ´Ù Â¦¼ö°Å³ª È¦¼ö¶ó¸é
						for(int p=0; p<8; p+=2) {//0,2,4,6
							list.add(new Shark(i, j, nm, ns, p));
						}
					} else {
						for(int p=1; p<8; p+=2) {//1,3,5,7
							list.add(new Shark(i, j, nm, ns, p));
						}
					}
				} else {
					shark[i][j].clear();
				}
			}
		}
	}
}