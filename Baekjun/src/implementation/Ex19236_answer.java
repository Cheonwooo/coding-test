package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex19236_answer {
	public static class Fish{
		int x;
		int y;
		int num;
		int dir;
		int alive;
		
		public Fish(int x, int y, int num, int dir, int alive) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
			this.alive = alive;
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

		public final int getAlive() {
			return alive;
		}
	}
	
	public static int answer = 0;
	public static int[][] map;
	public static Fish[] fish;
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[4][4];
		fish = new Fish[17];
		
		
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken())-1;
				
				map[i][j] = num;
				
				fish[num] = new Fish(i, j, num, dir, 1);
				
			}
		}
		
		int x = 0;
		int y = 0;
		int eat = map[0][0];
		int d = fish[map[0][0]].dir;
		fish[map[0][0]].alive = 0;
		map[0][0] = 17;//상어 17, 벽 0
		
		dfs(x, y, d, eat);
//		fishMove();
//		for(int i=1; i<17; i++) {
//			System.out.println(fish[i].num + " " + fish[i].dir);
//		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int x, int y, int d, int eat) {
		answer = Math.max(answer, eat);
		System.out.println(answer);
		int[][] tempMap = new int[map.length][map.length];
		for(int i=0; i<map.length; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
		}
		
		Fish[] tempFish = new Fish[fish.length];
		for(int i=1; i<=16; i++) {
			tempFish[i] = new Fish(fish[i].x, fish[i].y, fish[i].num, fish[i].dir, fish[i].alive);
		}
		
		fishMove();
		
		
		for(int i=1; i<4; i++) {
			int nx = x + dx[d]*i;
			int ny = y + dy[d]*i;
			
			if(nx>=0 && nx<4 && ny>=0 && ny<4 && map[nx][ny]!=0) {
				int eatFish = map[nx][ny];
				int nd = fish[eatFish].dir;
				
				map[x][y] = 0;
				map[nx][ny] = 17;
				fish[eatFish].alive = 0;
				
				dfs(nx, ny, nd, eat+eatFish);
				
				fish[eatFish].alive = 1;
				map[x][y] = 17;
				map[nx][ny] = eatFish;
				
			}
		}
		
		for(int i=0; i<map.length; i++) {
			System.arraycopy(tempMap[i], 0, map[i], 0, map.length);
		}
		
		for(int i=1; i<=16; i++) {
			fish[i] = new Fish(tempFish[i].x, tempFish[i].y, tempFish[i].num, tempFish[i].dir, tempFish[i].alive);
		}
		System.out.println("copy done");
	}

	public static void fishMove() {
		for(int i=1; i<17; i++) {
			if(fish[i].alive==0) {
				continue;//죽은 물고기라면 패스
			}
			
			int cnt = 0;
			int dir = fish[i].dir;
			int nx = 0, ny = 0;
			
			while(cnt<8) {
				
				dir%=8;
				
				fish[i].dir = dir;
				
				nx = fish[i].x + dx[dir];
				ny = fish[i].y + dy[dir];
				
				if(nx>=0 && nx<4 && ny>=0 && ny<4 && map[nx][ny] != 17) {
					if(map[nx][ny]==0) {
						map[fish[i].x][fish[i].y] = 0;
						
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
					} else {
						int changeFish = fish[map[nx][ny]].num;
						
						fish[changeFish].x = fish[i].x;
						fish[changeFish].y = fish[i].y;
						map[fish[changeFish].x][fish[changeFish].y]= changeFish;
						 
						fish[i].x = nx;
						fish[i].y = ny;
						map[nx][ny] = i;
						
					}
					break;
				} else {
					dir++;
					cnt++;
				}
			}
		}
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(map[i][j]!=17 && map[i][j]!=0) {
					System.out.print(map[i][j] + " " + fish[map[i][j]].dir+ "/");
				} else {
					System.out.print(map[i][j] + " " + 0 + "/");
				}
				
			}System.out.println();
		}System.out.println();
	}
}
