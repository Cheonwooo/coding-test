package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1002 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int d = (int) (Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
			
			System.out.println(r1);
			System.out.println(r2);
			System.out.println(r1+r2);
			System.out.println(d);
			if(d==0 && r1==r2) {
				sb.append(-1).append('\n');
			} else if(Math.pow(r1+r2, 2)==d || Math.pow(r1-r2, 2)==d) {
				sb.append(1).append('\n');
			} else if(Math.pow(r1+r2, 2) < d || Math.pow(r1-r2, 2) > d) {
				sb.append(0).append('\n');
			} else {
				sb.append(2).append('\n');
			}
			
		}
		System.out.println(sb);
	}

}
