package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex10709 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		char[][] map = new char[h][w];
		int[][] arr = new int[h][w];
		
		
		for(int i=0; i<h; i++) {
			Arrays.fill(arr[i], -1);
		}
		
		for(int i=0; i<h; i++) {
			String str = br.readLine();
			int cnt=-1;
			boolean check = false;
			
			for(int j=0; j<w; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='c') {
					arr[i][j]=0;
					cnt=0;
					check = true;
				} else if(check && map[i][j]=='.') {
					cnt++;
					arr[i][j] = cnt;
				} else if(!check && map[i][j]=='.') {
					arr[i][j] = cnt;
				}
			}
			
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				System.out.print(arr[i][j] + " ");
			}System.out.println();
		}
	}

}
