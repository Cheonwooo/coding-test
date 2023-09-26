package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex19238 {
	public static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int dist;
		int num;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
		public Pair(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
		public Pair(int x, int y, int dist, int num) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.num = num;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}

		public final int getDist() {
			return dist;
		}
		
		public final int getNum() {
			return num;
		}

		public int compareTo(Pair o) {
			if(this.dist==o.dist && this.x==o.x) {
				return this.y - o.y;
			} else if(this.dist==o.dist) {
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}
		
	}
	
	public static int a, b, n, m, f, sum;
	public static boolean check = false;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int[][] map, temp;
	public static boolean[][] visited;
	public static PriorityQueue<Pair> pq;
	public static ArrayList<Pair> customer = new ArrayList<>();
	public static ArrayList<Pair> taxi = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			
			customer.add(new Pair(hx, hy, i));
			taxi.add(new Pair(tx, ty, i));
			visited[hx][hy] = true;
		}
		
		while(true) {
			if(check) {
				System.out.println(-1);
				break;
			}
			if(customer.size()==0) {
				System.out.println(f);
				break;
			}
			
			sum = 0;
			//1.최단거리 구하기
			bfs(a, b);
			start();
		}
		
	}
	public static void bfs(int x, int y) {//(x,y)에서 최단거리 구하기
		temp = new int[n+1][n+1];
		copy();
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			x = cur.getX();
			y = cur.getY();
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx<=0 || nx>n || ny<=0 || ny>n) continue;
				if(temp[nx][ny]==1) continue;
				if(temp[nx][ny]==0) {
					temp[nx][ny] = temp[x][y]+1;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}
	
	public static void start() {
		pq = new PriorityQueue<>();
		if(visited[a][b]) {
			temp[a][b] = 0;
		}
		for(int i=0; i<customer.size(); i++) {
			int cx = customer.get(i).getX();
			int cy = customer.get(i).getY();
			int cNum = customer.get(i).getNum();
			
			pq.add(new Pair(cx, cy, temp[cx][cy], cNum));
		}
		
		Pair cur = pq.poll();//최솟값 추출
		
		int cx = cur.getX();
		int cy = cur.getY();
		int cDist = cur.getDist();
		int cNum = cur.getNum();
		
		//갈 수 없는 경우
		if(cx!=a || cy!=b) {
			if(cDist==0) {
				check = true;
				return;
			}
		}
		
		f -= cDist;
		
		if(f<=0) {
			check = true;
			return;
		}
		
		int del = 0;
		for(int i=0; i<customer.size(); i++) {
			//최솟값이었던 손님과 고유 번호 찾기
			if(cNum == customer.get(i).getNum()) {
				del = i;
			}
		}
		customer.remove(del);
		
		a = cx;
		b = cy;
		visited[a][b] = false;
		
		//손님 위치에서 목적지까지 최솟값
		bfs(a,b);
		
		for(int i=0; i<taxi.size(); i++) {
			//손님의 목적지를 찾았다면
			if(cNum == taxi.get(i).getNum()) {
				cx = taxi.get(i).getX();
				cy = taxi.get(i).getY();
			}
		}
//		for(int i=1; i<n+1; i++) {
//			for(int j=1; j<n+1; j++) {
//				System.out.print(temp[i][j] + " " );
//			}System.out.println();
//		}System.out.println();
		
		
		//목적지를 갈 수 없는 상황이라면(벽에 막히거나 연료가 없는경우)
		if(cx!=a || cy!=b) {
			if(temp[cx][cy]==0) {
				check = true;
				return;
			}
		}
		
		f -= temp[cx][cy];
		sum += temp[cx][cy]*2;
		
		if(f<0) {
			check = true;
			return;
		}
		
		a = cx;
		b = cy;
		f += sum;
	}
	
	public static void copy() {
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}
}


