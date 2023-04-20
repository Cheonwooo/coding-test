package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1004 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st1.nextToken());
			int y1 = Integer.parseInt(st1.nextToken());
			int x2 = Integer.parseInt(st1.nextToken());
			int y2 = Integer.parseInt(st1.nextToken());
			
			int n = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			for(int j=0; j<n; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				
				int cx = Integer.parseInt(st2.nextToken());
				int cy = Integer.parseInt(st2.nextToken());
				int r = Integer.parseInt(st2.nextToken());
				
				int d1 = (int)(Math.pow(cx-x1, 2)+Math.pow(cy-y1, 2)); 
				int d2 = (int)(Math.pow(cx-x2, 2)+Math.pow(cy-y2, 2));
				
				if(d1<Math.pow(r, 2) && d2>Math.pow(r, 2)) {
					cnt++;
				} else if(d1>Math.pow(r, 2) && d2<Math.pow(r, 2)) {
					cnt++;
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.println(sb);
	}

}
