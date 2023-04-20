package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex3009 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arrx= new int[1001];
		int[] arry= new int[1001];
		
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arrx[x]++;
			arry[y]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<1001; i++) {
			if(arrx[i]==1) {
				sb.append(i).append(' ');
			}
		}
		for(int i=0; i<1001; i++) {
			if(arry[i]==1) {
				sb.append(i).append(' ');
			}
		}
		System.out.println(sb);
	}

}
