package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex16918 {
	public static int r, c, cnt;
	public static int[] dx = {-1, 0, 1, 0};
	public static int[] dy = {0, 1, 0, -1}; 
	public static int[][] bomb, temp;
	public static char[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		if(n%2==0) {
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					System.out.print("O");
				}
				System.out.println();
			}
		} else {
			char[][] newMap = new char[r][c];
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					newMap[i][j] = map[i][j];
				}
			}
			
			for(int cnt=2; cnt<=n; cnt++) {
				if(cnt%2==0) {
					for(int i=0; i<r; i++) {
						for(int j=0; j<c; j++) {
							if(map[i][j]=='.') {
								map[i][j]='O';
							}
						}
					}
				} else {
					for(int i=0; i<r; i++) {
						for(int j=0; j<c; j++) {
							if(newMap[i][j]=='O') {
								map[i][j] = '.';
								
								for(int p=0; p<4; p++) {
									int nx = i + dx[p];
									int ny = j + dy[p];
									
									if(nx>=0 && nx<r && ny>=0 && ny<c) {
										map[nx][ny] = '.';
									}
								}
							}
						}
					}
					
					for(int i=0; i<r; i++) {
						for(int j=0; j<c; j++) {
							newMap[i][j] = map[i][j];
						}
					}
				}
			}
			
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
