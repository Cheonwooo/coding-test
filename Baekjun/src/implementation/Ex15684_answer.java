package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//가로선이 h개임!!!
public class Ex15684_answer {
	
	public static boolean finish = false;
	public static int n, m, h, answer;
	public static int[][] lad;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		lad = new int[h+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			lad[a][b] = 1;//오른쪽
			lad[a][b+1] = 2;//왼쪽
		}
		
		for(int i=0; i<=3; i++) {
			answer = i;
			dfs(0);
			if(finish) break;
		}
		
		System.out.println((finish) ? answer : -1);
	}
	
	public static void dfs(int depth) {
		if(finish) return;
		if(answer == depth) {
			if(check()) finish = true;
			return;
		}
		
		for(int i=1; i<h+1; i++) {
			for(int j=1; j<n; j++) {
				if(lad[i][j]==0 && lad[i][j+1]==0) {
					lad[i][j] = 1;
					lad[i][j+1] = 2;
					dfs(depth+1);
					lad[i][j] = 0;
					lad[i][j+1] = 0;
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i=1; i<=n; i++) {
			int x=1, y=i;
			
			for(int j=0; j<h; j++) {
				if(lad[x][y]==1) y++;
				else if(lad[x][y]==2) y--;
				x++;
			}
			
			if(y!=i) return false;
		}
		return true;
	}

}
