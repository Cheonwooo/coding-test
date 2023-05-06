package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 0:동, 1:북, 2:서, 3:남
 * 사과의 위치를 저장할 boolean[]
 * 뱀의 길이를 저장할 boolean[]
 * 방향 변경 정보를 저장할 HashMap
 * 뱀의 방향을 나타낼 d
 * 몇초인지 나타낼 cnt
 * 방향 전환을 할 함수 direc
 * 자기 자신 몸과 부딪힘 or 벽인지 체크할 check 함수
 */
public class Ex3190 {
	public static int x, y, n, dir;
	public static boolean[][] snake;
	public static boolean[][] apple;
	public static HashMap<Integer, String> map = new HashMap<Integer, String>();
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		snake = new boolean[n][n];
		apple = new boolean[n][n];
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int apple_x = Integer.parseInt(st.nextToken())-1;
			int apple_y = Integer.parseInt(st.nextToken())-1;
			
			apple[apple_x][apple_y] = true;
		}
		
		int l = Integer.parseInt(br.readLine());
		
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			
			map.put(count, d);
		}
		
		x = 0;
		y = 0;
		int tail_x;
		int tail_y;
		snake[x][y] = true;
		int cnt = 0;//초를 셀 카운트
		dir = 100;
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));
		Pair cur;
		
		while(!check(dir%4)) {//check가 true가 될 때까지
			x += dx[dir%4];
			y += dy[dir%4];
			
			if(apple[x][y]==true) {//이동한 칸에 사과가 있다면 사과는 없어지고 꼬리는 움직이지 않음
				q.add(new Pair(x,y));
				snake[x][y] = true;
				apple[x][y] = false;
			} else {//이동한 칸에 사과가 없다면 몸길이를 줄여서 꼬리가 위치한 칸을 비움.
				q.add(new Pair(x,y));
				cur = q.poll();
				tail_x = cur.x;
				tail_y = cur.y;
				snake[tail_x][tail_y]=false;
				snake[x][y]=true;
			}
			cnt++;
			if(map.containsKey(cnt)) {
				changeDirection(map.get(cnt));
			}
			
			
		}
		System.out.println(cnt+1);
	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static boolean check(int direction) {
		int nx = x + dx[direction];
		int ny = y + dy[direction];
		
		if(nx<=-1 || nx>=n || ny<=-1 || ny>=n) {//다음칸이 벽이라면 true 끝
			return true;
		}
		if(snake[nx][ny]==true) {//다음칸이 자기 몸이라면 true 끝
			return true;
		}
		return false;
	}
	
	public static void changeDirection(String direction) {
		if(direction.equals("D")) {
			dir--;
		} else if(direction.equals("L")) {
			dir++;
		}
	}

}
