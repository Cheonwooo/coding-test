package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex21608 {
	public static class Pair implements Comparable<Pair>{
		int cnt;
		int temp;
		int x;
		int y;
		
		public Pair(int cnt, int temp, int x, int y) {
			this.cnt = cnt;
			this.temp = temp;
			this.x = x;
			this.y = y;
		}
		
		public final int getCnt() {
			return cnt;
		}
		
		public final int getTemp() {
			return temp;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}
		
		public int compareTo(Pair o) {
			if(this.cnt == o.cnt && this.temp == o.temp && this.x == o.x) {
				return this.y - o.y;
			} else if(this.cnt == o.cnt && this.temp == o.temp) {
				return this.x - o.x;
			} else if(this.cnt == o.cnt) {
				return o.temp - this.temp;
			}
			return o.cnt - this.cnt;
		}
		
	}
	
	public static PriorityQueue<Pair> pq;
	public static Queue<Integer> q = new LinkedList<>();
	public static int n, sum;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int[][] answer, student, like, empty;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		answer = new int[n+1][n+1];
		student = new int[n*n+1][4];
		
		for(int i=0; i<n*n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<4; j++) {
				student[num][j] = Integer.parseInt(st.nextToken());
			}
			q.offer(num);
		}
		
		sum = 0;
		while(!q.isEmpty()) {
			pq = new PriorityQueue<>();
			like = new int[n+1][n+1];
			empty = new int[n+1][n+1];
			int stu = q.poll();
			
			love(stu);
			Pair cur =  pq.poll();
			
			
			answer[cur.getX()][cur.getY()] = stu;
			
//			for(int i=1; i<n+1; i++) {
//				for(int j=1; j<n+1; j++) {
//					System.out.print(answer[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		check();
		System.out.println(sum);
		
	}
	
	public static void love(int stu) {
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(answer[i][j]!=0) continue;
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx<1 || nx>n || ny<1 || ny>n) continue;
					
					for(int p=0; p<4; p++) {
						if(answer[nx][ny] == student[stu][p]) {//stu번호의 학생이 선호하는 학생의 번호가 있다면
							like[i][j]++;
						}
					}
					if(answer[nx][ny]==0) {
						empty[i][j]++;
					}
				pq.offer(new Pair(like[i][j], empty[i][j], i, j));
				}
			}
		}
	}
	
	public static void check() {
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				int stu = answer[i][j];
				int cnt = 0;
				
				for(int k=0; k<4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					
					if(nx<1 || nx>n || ny<1 || ny>n) continue;
					
					for(int p=0; p<4; p++) {
						if(answer[nx][ny] == student[stu][p]) cnt++;
					}
				}
				
				if(cnt==0) sum += 0;
				else {
					sum += (int)Math.pow(10, cnt-1);
				}
			}
		}
	}
}
