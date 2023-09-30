package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex17837 {
	public static class Card{
		int x;
		int y;
		int num;
		int d;
		
		public Card(int num, int d) {
			this.num = num;
			this.d = d;
		}
		
		public Card(int x, int y, int num ,int d) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.d = d;
		}

		public final int getNum() {
			return num;
		}

		public final int getD() {
			return d;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}
	}
	
	public static int n, k;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {1, -1, 0, 0};
	public static int[][] map;
	public static ArrayList<Card> card;
	public static ArrayList<Card>[][] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		card = new ArrayList<>();
		list = new ArrayList[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			
			list[x][y].add(new Card(i+1, d));
			card.add(new Card(x, y, i+1 ,d));
		}

//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				System.out.print(list[i][j].size() + " ");
//			}System.out.println();
//		}System.out.println();
	
		int cnt = 1;
		
		while(true) {
			if(cnt>1000) {
				System.out.println(-1);
				break;
			}
			if(game()) {
				System.out.println(cnt);
				break;
			} else {
				cnt++;
			}
//			if(cnt==1000) {
//				for(int i=0; i<n; i++) {
//					for(int j=0; j<n; j++) {
//						System.out.print(list[i][j].size() + " ");
//					}System.out.println();
//				}System.out.println();
//			}
			
		}
	}
	public static boolean game() {

		for(int i=0; i<card.size(); i++) {
			
			int cx = card.get(i).getX();
			int cy = card.get(i).getY();
			int cNum = card.get(i).getNum();
			int cd = card.get(i).getD();
			
			int nx = cx + dx[cd];
			int ny = cy + dy[cd];
			
			int start = 0;
			for(int j=0; j<list[cx][cy].size(); j++) {
				if(list[cx][cy].get(j).getNum()==cNum) {
					start = j;
				}
			}
			
			//벽일경우 nx, ny 재정의
			if(nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny]==2) {
				if(cd==0 || cd==2) {
					cd+=1;
				} else if(cd==1 || cd==3) {
					cd-=1;
				}
				list[cx][cy].get(start).d = cd;
				card.get(i).d = cd;
			}
			nx = cx + dx[cd];
			ny = cy + dy[cd];
			if(nx<0 || nx>=n || ny<0 || ny>=n || map[nx][ny]==2) continue;
			else if(map[nx][ny] == 0) {
				int del = 0;
				for(int j=start; j<list[cx][cy].size(); j++) {
					cNum = list[cx][cy].get(j).getNum();
					cd = list[cx][cy].get(j).getD();
					
					list[nx][ny].add(new Card(cNum, cd));
					card.get(cNum-1).x = nx;
					card.get(cNum-1).y = ny;
					card.get(cNum-1).d = cd;
//					System.out.println(nx + " " + ny + " " + cNum + " " + cd);
					del++;
				}
				for(int j=0; j<del; j++) {
					list[cx][cy].remove(start);
				}
			} else if(map[nx][ny] == 1) {
				int del = 0;
				for(int j=list[cx][cy].size()-1; j>=start; j--) {
					cNum = list[cx][cy].get(j).getNum();
					cd = list[cx][cy].get(j).getD();
					
					list[nx][ny].add(new Card(cNum, cd));
					card.get(cNum-1).x = nx;
					card.get(cNum-1).y = ny;
					card.get(cNum-1).d = cd;
//					System.out.println(nx + " " + ny + " " + cNum + " " + cd);
					del++;
				}
				for(int j=0; j<del; j++) {
					list[cx][cy].remove(list[cx][cy].size()-1);
				}
			}
			if(check()) {
				return true;
			}
		}
		return false;
	}
	public static boolean check() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(list[i][j].size()>=4) return true;
			}
		}
		return false;
	}
}
//4 1
//0 0 0 0
//0 0 0 0
//2 0 0 0
//0 2 0 0
//4 1 1
