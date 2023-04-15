package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Page110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		String[] arr = {"U", "D", "L", "R"};
		int x = 1, y = 1;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			String move = st.nextToken();
			
			for(int i=0; i<4; i++) {
				if(move.equals(arr[i])) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx <= 0 || nx > n || ny <= 0 || ny > n) {
						continue;
					}
					x = nx;
					y = ny;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		sb.append(x).append(" ").append(y);
		System.out.println(sb);
	}

}
