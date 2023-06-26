package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q13 {
	public static int n, m, answer;
	public static ArrayList<Pair> home, chk_home;
	public static boolean[] chicken;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map  = new int[n][n];
		
		home = new ArrayList<>();
		chk_home = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {//집 좌표 저장
					home.add(new Pair(i, j));
				} else if(map[i][j] == 2) {//치킨집 좌표 저장
					chk_home.add(new Pair(i,j));
				}
			}
		}
		
		chicken = new boolean[chk_home.size()];
		answer = Integer.MAX_VALUE;
		
		dfs(0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int start, int count) {
		if(count == m) {
			
			int sum =0;
			
			for(int i=0; i<home.size(); i++) {
				int hx = home.get(i).x;
				int hy = home.get(i).y;
				int min = Integer.MAX_VALUE;

				
				for(int j=0; j<chk_home.size(); j++) {
					if(chicken[j]) {
						int cx = chk_home.get(j).x;
						int cy = chk_home.get(j).y;
						
						int dis = Math.abs(cx-hx)+Math.abs(cy-hy);
						min = Math.min(min, dis);
					}
				}
				
				sum += min;
			}
			
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=start; i<chk_home.size(); i++) {
			chicken[i] = true;
			dfs(i + 1, count + 1);
			chicken[i] = false;
		}
	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
