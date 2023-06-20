package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pair{
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Ex15686_2 {
	public static int n, k, answer, sum;
	public static int[][] map;
	public static boolean[] visited;
	public static ArrayList<Pair> home;
	public static ArrayList<Pair> chk;

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		home = new ArrayList<Pair>();
		chk = new ArrayList<Pair>();
		
		
		for(int i=0; i<n; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<n; j++) {
				
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j]==2) {
					
					chk.add(new Pair(i,j));
					
				} else if(map[i][j]==1){
					
					home.add(new Pair(i,j));
					
				}
			}
		}
		visited = new boolean[chk.size()];
		
		answer = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt==k) {
			int sum =0;
			
			for(int i=0; i<home.size(); i++) {
				
				int min = Integer.MAX_VALUE;
				
				for(int j=0; j<chk.size(); j++) {
					if(visited[j]) {
						int dis = (int)((Math.abs(chk.get(j).x - home.get(i).x) 
								+ Math.abs(chk.get(j).y) - home.get(i).y));
						min = Math.min(min, dis);
					}
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=start; i<chk.size(); i++) { //치킨집 고르기
			visited[i] = true;
			dfs(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

}
