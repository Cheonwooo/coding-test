package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex20057 {
	public static int n, sum;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static int[][] map, arr, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		arr = new int[5][5];
		temp = new int[5][5];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr[2][1]=55;
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==0) {
					arr[2][i]=5;
				} else if(i==1 && j%2==1) {
					arr[j][i]=10;
				} else if(i==2 && j%2==0 && j!=2) {
					arr[j][i]=2;
				} else if(i==2 && j%2==1) {
					arr[j][i]=7;
				} else if(i==3 && j%2==1) {
					arr[j][i]=1;
				}
			}
		}
		
		sum = 0;
		
		int d = 3;
		int x = n/2;
		int y = n/2;
		int time = 0;
		int cnt = 0;
		while(true) {
			if(time==0) {
				cnt = 1;
			} else {
				cnt = time;
			}
			
			for(int i=0; i<=cnt/2; i++) {
				x += dx[d];
				y += dy[d];
				spread(x,y);
				if(x==0 && y==0) break;
			}
			if(x==0 && y==0) break;
			turn();
			d--;
			if(d==-1) d=3;
			time++;
		}
		System.out.println(sum);
		
		
		
	}
	
	public static void turn() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				temp[i][j] = arr[j][4-i];
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
	
	public static void spread(int x, int y) {
		int now = map[x][y];
		
		int nx = x-2;
		int ny = y-2;
		int cx = 0;
		int cy = 0;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(arr[i][j]==55) {
					cx = i;
					cy = j;
					continue;
				}
				if(nx+i<0 || nx+i>=n || ny+j<0 || ny+j>=n) {
					sum += (int)(now*(0.01*arr[i][j]));//바깥으로 나가는 값
					map[x][y] -= (int)(now*(0.01*arr[i][j]));
					continue;
				}
				map[nx+i][ny+j] += (int)(now*(0.01*arr[i][j]));
				map[x][y] -= (int)(now*(0.01*arr[i][j]));
			}
		}
		if(nx+cx<0 || nx+cx>=n || ny+cy<0 || ny+cy>=n) {
			sum += map[x][y];
		} else {
			map[nx+cx][ny+cy] += map[x][y];
		}
		map[x][y]=0;
		
	}

}
