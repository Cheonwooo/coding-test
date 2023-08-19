package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1063 {
	public static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
	public static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String king = st.nextToken();
		String stone = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		
		int ky = king.charAt(0)-'A'+1;
		int kx = (int)king.charAt(1)-'0';
		
		int sy = stone.charAt(0) - 'A'+1;
		int sx = (int)stone.charAt(1)-'0';

		for(int i=0; i<n; i++) {
			String move = br.readLine();
			
			int idx = check(move);
			
			int nkx = kx + dx[idx];
			int nky = ky + dy[idx];
			
			if(nkx<1 || nkx>=9 || nky<1 || nky>=9) continue;
			
			if(nkx==sx && nky==sy) {
				int nsx = sx + dx[idx];
				int nsy = sy + dy[idx];
				
				if(nsx<1 || nsx>=9 || nsy<1 || nsy>=9) continue;
				sx = nsx;
				sy = nsy;
			}
			
			kx = nkx;
			ky = nky;
		}
		
		String answerK = String.valueOf((char)(ky+64)) + String.valueOf(kx);
		String answerS = String.valueOf((char)(sy+64)) + String.valueOf(sx);
		System.out.println(answerK);
		System.out.println(answerS);
	}
	
	public static int check(String move) {
		if(move.equals("R")) return 0;
		else if(move.equals("L")) return 1;
		else if(move.equals("B")) return 2;
		else if(move.equals("T")) return 3;
		else if(move.equals("RT")) return 4;
		else if(move.equals("LT")) return 5;
		else if(move.equals("RB")) return 6;
		else if(move.equals("LB")) return 7;
		return 0;
	}

}
