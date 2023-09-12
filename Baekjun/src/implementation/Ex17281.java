package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex17281 {
	public static int n, max;
	public static int[] cnt;
	public static int[][] hit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		hit = new int[n+1][10];
		
		for(int i=1; i<n+1; i++) {//이닝
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=1; j<10; j++) {
				hit[i][j] = Integer.parseInt(st.nextToken());//i번째 이닝에서 j번째 선수
			}
		}
		max = Integer.MIN_VALUE;
		int[] output = new int[9];
		cnt = new int[10];
		boolean[] visited = new boolean[10];
		comb(output, visited, 2, 0, 9);
		
		System.out.println(max);
	}
	
	public static void comb(int[] output, boolean[] visited, int start, int depth, int r) {
		if(depth==r) {
			output[3] = 1;
			
			max = Math.max(max, game(output));
			
			return;
		}
		
		for(int i=start; i<10; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(depth==3) depth++;
				output[depth] = i;
				comb(output, visited, start, depth+1, r);
				visited[i] = false;
			}
		}
	}
	
	public static int game(int[] output) {
		int start = 0;
		int score = 0;
		for(int i=1; i<n+1; i++) {//이닝
			int out = 0;
			int[] R = new int[4];//0:1루, 1:2루, 2:3루, 3:들어온 선수명수
				for(int j=start; j<9;) {
//					System.out.println(j + " " + hit[i][output[j]]);
					if(hit[i][output[j]]==0) {
						out++;
						if(out==3) {							
							start = j+1;
							if(j==8) start = 0;
//							System.out.println(start + " " + j);
							break;
						}
					} else if(hit[i][output[j]]==1) {//1루타
						for(int k=2; k>=0; k--) {
							if(R[k]!=0) {//k+1루에 선수가 있을 때
								R[k] = 0;
								R[k+1] += 1;
							}
						}
						R[0] = 1;
					} else if(hit[i][output[j]]==2) {//2루타
						if(R[2]!=0) {
							R[2] = 0;
							R[3] += 1;
						}
						if(R[1]!=0) {
							R[1] = 0;
							R[3] += 1;
						}
						if(R[0]!=0) {
							R[0] = 0;
							R[2] = 1;
						}
						R[1] = 1;
					} else if(hit[i][output[j]]==3) {//3루타
						for(int k=0; k<3; k++) {
							if(R[k]!=0) {//k+1루에 선수가 있다면 홈으로
								R[k]=0;
								R[3] += 1;
							}
						}
						R[2] = 1;
					} else if(hit[i][output[j]]==4) {//홈런
						for(int k=0; k<3; k++) {
							if(R[k]!=0) {
								R[k] = 0;
								R[3] += 1;
							}
						}
						R[3] += 1;
					}
					j++;
					if(j==9) j=0;
			}
			score += R[3];
		}
		return score;
	}
}
