package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14719 {
	
	public static int h, w;
	public static boolean[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new boolean[h][w];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n==0) continue;
			for(int j=0; j<n; j++) {
				map[j][i] = true;
			}
		}
		int cnt = 0;
		for(int i=0; i<h; i++) {
			Queue<Integer> q = new LinkedList<>();
			for(int j=0; j<w; j++) {
				if(map[i][j]) {
					q.offer(j);
				}
			}
			
			if(q.size()==0 || q.size()==1) break;
			
			int x = q.poll();
			
			while(!q.isEmpty()) {
				int nx = q.poll();
				
				if(nx-x==1) {//바로 옆에 붙어있다면
					x = nx;
					continue;
				}
				if(nx-x!=1) {//바로 옆에 붙어있는게 아니라면
					for(int k=x+1; k<nx; k++) {
						cnt++;
					}
					x = nx;
				}
			}
		}
		System.out.println(cnt);
	}
}
