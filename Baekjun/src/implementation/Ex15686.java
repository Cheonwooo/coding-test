package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class Point {
	int x;
	int y;
	
	Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Ex15686 {
	public static int n, k, chk_idx, hom_idx;
	public static int[][] arr;
	public static int min = Integer.MAX_VALUE;
	public static int ans;
	public static boolean[] chk;
	public static ArrayList<Point> chk_arr, hom_arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		chk_arr = new ArrayList<>();
		hom_arr = new ArrayList<>();
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					chk_arr.add(new Point(i, j));
				} else if(arr[i][j]==1) {
					hom_arr.add(new Point(i, j));
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		chk = new boolean[chk_arr.size()];
		chicken(0, 0);
		
		System.out.println(ans);
		//2를 먼저 고르고 2들의 좌표값에서 1까지의 거리를 구한 후 최솟값 구하고 더하기
		
	}
	
	
	
	public static void chicken(int start, int cnt) {
		//치킨집을 k개 만큼 고른 경우
		if(cnt==k) {//각 치킨집에서 집까지의 거리
			int sum = 0;
			
			for(int i=0; i<hom_arr.size(); i++) {
				int min = Integer.MAX_VALUE;
				
				for(int j=0; j<chk_arr.size(); j++) {
					if(chk[j]) {
						int dis = (int)((Math.abs(chk_arr.get(j).x - hom_arr.get(i).x)) +
								(Math.abs(chk_arr.get(j).y - hom_arr.get(i).y)));
						
						min = Math.min(min, dis);
					}
				}
				sum += min;
			}
			ans = Math.min(sum, ans);
			return;
		}
		
		for(int i=start; i<chk_arr.size(); i++) {
			chk[i] = true;
			chicken(i + 1, cnt + 1);
			chk[i] = false;
		}
	}

}
