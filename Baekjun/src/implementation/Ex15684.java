package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex15684 {
	public static int n, m, h, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static int[] lad;
	public static int[][] output;
	public static boolean[][] visited;
	public static boolean[][][] check, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());//세로선
		m = Integer.parseInt(st.nextToken());//가로선
		h = Integer.parseInt(st.nextToken());
		
		output = new int[m+5][2];
		lad = new int[n];
		check = new boolean[m+5][11][2];//[][][0]:left, [][][1]:right
		temp = new boolean[m+5][11][2];
		visited = new boolean[m+5][11];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			max = Math.max(max, a);
			check[a][b][1] = true;
			check[a][b+1][0] = true;
			lad[b]++;
		}
		if(m==0) {
			System.out.println(0);
		} else {
			for(int i=0; i<4; i++) {
				perm(output, check, 0, i);
			}
			
			if(min == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
		}
	}

	public static boolean start(int x, int y, int i) {
		while(true) {
			x += 1;//한칸 아래로
			if(x==m+5) break;
			if(y-1>0 && temp[x][y][0] && temp[x][y-1][1]) {
				y-=1;
			} else if(y+1<n+1 && temp[x][y][1] && temp[x][y+1][0]) {
				y+=1;
			}
		}
//		System.out.println("i : " + i +", y : " + y);
		if(i==y) return true;
		else return false;
	}
	
	public static void perm(int[][] output, boolean[][][] check, int depth, int r) {
		if(depth == r) {
			
//			for(int i=0; i<r; i++) {
//				System.out.println(output[i][0] + " " + output[i][1]);
//			}
//			System.out.println();
			for(int i=0; i<m+4; i++) {
				for(int j=0; j<n+1; j++) {
					for(int k=0; k<2; k++) {
						temp[i][j][k] = check[i][j][k];
					}
				}
			}
			
			for(int i=0; i<r; i++) {
//				System.out.println(output[i][0] + " " + output[i][1]);
				temp[output[i][0]][output[i][1]][1]=true;
				temp[output[i][0]][output[i][1]+1][0]=true;
			}
			
//			for(int i=1; i<max+4; i++) {
//				for(int j=1; j<n+1; j++) {
//					if(temp[i][j][1] || temp[i][j][0]) System.out.print(1);
//					else System.out.print(0);
//				}System.out.println();
//			}System.out.println();
			
			boolean answer = true;
			for(int i=1; i<n+1; i++) {
				if(!start(0, i, i)) {//i!=y가 하나라도 있으면 answer = false
					answer = false;
				}
			}
			if(answer){//모든 i가 y랑 같다면
				min = Math.min(min, depth);
//				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			}
			return;
		}
		
		
			for(int i=1; i<n; i++) {
				for(int j=1; j<max+4; j++) {
					if(lad[i]<h && !check[j][i][0] && !check[j][i][1] && !check[j][i+1][0] && !check[j][i+1][1] && !visited[j][i]) {
						visited[j][i] = true;
						check[j][i][1] = true;
						check[j][i+1][0] = true;
						output[depth][0] = j;//x좌표
						output[depth][1] = i;//y좌표
						lad[i]+=1;
						perm(output, check, depth+1, r);
						visited[j][i] = false;
						check[j][i][1] = false;
						check[j][i+1][0] = false;
						lad[i]-=1;
					}
				}
			}
	}
}
