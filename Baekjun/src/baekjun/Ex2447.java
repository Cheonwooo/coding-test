package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2447 {
	
	static char[][] arr;
	
	public static void star(int x, int y, int N, boolean blank) {
		if(blank) {
			for(int i=x; i<x+N; i++) {
				for(int j=y; j<y+N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		//N=9
		//size = 3
		//0 9
		if(N==1) {
			arr[x][y]='*';
			return;
		}
		
		int size = N/3;
		int cnt = 0;
		for(int i=x; i<x+N; i += size) {
			for(int j=y; j<y+N; j += size) {
				cnt++;
				if(cnt==5) {
					star(i,j,size,true);
				} else {
					star(i,j,size,false);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		//k=1 2      3/3 + 1				3/2/3
		//k=2 4~6    9/3 + 1 ~ 9/3 * 2		9/6/9 6/4/6 9/6/9
		//k=3 10~18  27/3 + 1 ~ 27/3 * 2	27/18/27 18/12/18 27/18/27
		//k=4 28~51  81/3 + 1 ~ 81/3 * 2	81/54/81 54/36/54 81/54/81
		//if(k=1) else(k>1)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		star(0,0,N,false);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
