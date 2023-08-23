package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2615 {
	public static int sum, num, answerX, answerY;
	public static int[][] map;
	
	public static boolean check;
	public static int[] dx = {-1, 0, -1, 1};//∫œµø≥≤º≠ øﬁ¿ß ø¿¿ß ø¿æ∆∑° øﬁæ∆∑°
	public static int[] dy = {0, 1, 1, 1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[19][19];
		
		
		for(int i=0; i<19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(map[j][i]==1 || map[j][i]==2) {
					for(int k=0; k<4; k++) {
						int nx = j;
						int ny = i;
						int sum = 1;
						
						while(true) {
							nx += dx[k];
							ny += dy[k];
							
							if(nx>=0 && nx<19 && ny>=0 && ny<19) {
								if(map[nx][ny] == map[j][i]) sum++;
								else break;
							} else break;
						}
						nx = j;
						ny = i;
						while(true) {
							nx -= dx[k];
							ny -= dy[k];
							
							if(nx>=0 && nx<19 && ny>=0 && ny<19) {
								if(map[nx][ny] == map[j][i]) sum++;
								else break;
							} else break;
						}
						if(sum==5) {
							System.out.println(map[j][i]);
							System.out.println((j+1) + " " + (i+1));
							return;
						}
					}
				}
			}
		}

		System.out.println(0);
		
	}

//	public static void check(int x, int y) {
//		
//		num = map[x][y];
//		answerX = x+1;
//		answerY = y+1;
//		
//		for(int i=0; i<8; i++) {
//			
//			x = answerX-1;
//			y = answerY-1;
//
//			sum = 1;
//			
//			while(true) {
//
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				
//				if(nx>=0 && nx<19 && ny>=0 && ny<19) {
//					if(map[nx][ny]!=num) break;
//					
//					else if(map[nx][ny]==num){
//						
//						sum++;
//
//						x = nx;
//						y = ny;
//						
//					}
//				} else break;
//			}
//			if(sum==5) break;
//		}
//	}
}
/*
2 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
2 2 2 2 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
1 1 2 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
1 0 1 2 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0
1 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
1 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 1 1 1 0 1 0 0 0 0 0 0 0 0
0 0 1 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
*/
