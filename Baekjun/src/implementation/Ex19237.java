package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex19237 {
	public static class Shark{
		int x;
		int y;
		int num;
		int d;
		int time;
		
		public Shark(int num) {
			this.num = num;
		}
		
		public Shark(int num, int time) {
			this.num = num;
			this.time = time;
		}
		
		public Shark(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
		public Shark(int x, int y, int num, int time) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.time = time;
		}
		
		public Shark(int x, int y, int num, int d, int time) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.d = d;
			this.time = time;
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

		public final int getD() {
			return d;
		}

		public final int getTime() {
			return time;
		}
		
	}
	
	public static int n, m, k;
	public static int[] dx = {-1, 1, 0, 0};
	public static int[] dy = {0, 0, -1, 1};
	public static int[][][] sharkD;
	public static boolean[][] visited;
	public static ArrayList<Shark> shark = new ArrayList<>();
	public static Shark[][] map, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new Shark[n][n];
		temp = new Shark[n][n];
		visited = new boolean[n][n];
		sharkD = new int[m][4][4];
		
		for(int i=0; i<m; i++) {
			shark.add(new Shark(i+1));
		}
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==0) {
					map[i][j] = new Shark(num, 0);
				} else {
					map[i][j] = new Shark(num, k);
					visited[i][j] = true;
					shark.get(num-1).x = i;
					shark.get(num-1).y = j;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			shark.get(i).d = Integer.parseInt(st.nextToken())-1;
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int p=0; p<4; p++) {
					sharkD[i][j][p] = Integer.parseInt(st.nextToken())-1;
				}
			}
		}
		
		int cnt = 1;
		
		while(true) {
			temp = new Shark[n][n];
			if(cnt>1000) {
				System.out.println(-1);
				break;
			}
			move();
			
			if(!check()) {//���� �� 1���� ���Ҵٸ�
				System.out.println(cnt);
				break;
			} else {
				cnt++;
			}
		}
	}
	
	public static void move() {
		for(int i=0; i<m; i++) {//ù��° ������ �̵� ����
			int num = shark.get(i).getNum();
			int d = shark.get(i).getD();//����� ���� ����
			int x = shark.get(i).getX();
			int y = shark.get(i).getY();
			
			if(num==0) continue;//���� ���� �н�
			boolean check = false;//��ĭ�� ������� false
			for(int j=0; j<4; j++) {
				int nd = sharkD[i][d][j];//����� �켱����
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;//���̶�� �н�
				if(map[nx][ny].num==0 && map[nx][ny].time==0) {//��ĭ�̶��
					check = true;//��ĭ�� ������ true
					//���� �ִ� �ڸ��� ���� �����
					visited[x][y] = false;
					//���ο� �������� �̵�
					//�̹� �� ���⿡ ������ ���� �� �ִ°��
					if(temp[nx][ny]!=null && temp[nx][ny].getNum()!=0) {
						shark.get(i).num = 0;
						break;
					}
					//�� ���⿡ �ƹ��� ���ٸ� �̵�
					temp[nx][ny] = new Shark(num, k);
					visited[nx][ny] = true;
					shark.get(i).x = nx;
					shark.get(i).y = ny;
					shark.get(i).d = nd;
					break;
				}
			}
			if(!check) {//��ĭ�� ���ٸ� �ڱ��� ������ �ִ� �������� ��
				for(int j=0; j<4; j++) {
					int nd = sharkD[i][d][j];
					int nx = x + dx[nd];
					int ny = y + dy[nd];
					
					if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
					//�ڽ��� ������ �ִ� �����̶��
					if(map[nx][ny].num==num) {
						visited[x][y] = false;
						
						temp[nx][ny] = new Shark(num, k);
						visited[nx][ny] = true;
						shark.get(i).x = nx;
						shark.get(i).y = ny;
						shark.get(i).d = nd;
						break;
					}
				}
			}
		}
		copy();
		timeOut();
	}
	
	public static void copy() {//temp�� �� map���� ī��
		//����� ��ġ��, �ش� ��ġ�� �ð� �ű��
		for(int i=0; i<m; i++) {
			int num = shark.get(i).getNum();
			if(num==0) continue;
			
			int x = shark.get(i).getX();
			int y = shark.get(i).getY();
			int time = temp[x][y].getTime();
			
			
			map[x][y] = new Shark(num, time);
		}
	}
	
	public static void timeOut() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j]!=null && map[i][j].getTime()!=0) {
					map[i][j].time -= 1;
					if(map[i][j].getTime()==0) {
						map[i][j].num = 0;
					}
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i=1; i<m; i++) {
			if(shark.get(i).getNum()!=0) return true;//���� 1�� ���� �� ���Ҵٸ� true
		}
		return false;
	}
}
