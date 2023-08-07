package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex5635 {
	
	public static class Info implements Comparable<Info>{
		String name;
		int d;
		int m;
		int y;
		
		public Info(String name, int d, int m, int y) {
			this.name = name;
			this.d = d;
			this.m = m;
			this.y = y;
		}

		public final String getName() {
			return name;
		}

		public final int getD() {
			return d;
		}

		public final int getM() {
			return m;
		}

		public final int getY() {
			return y;
		}
		
		public int compareTo(Info other) {
			if(this.y == other.y && this.m == other.m) {
				return this.d - other.d;
			} else if(this.y == other.y) {
				return this.m - other.m;
			}
			return this.y - other.y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Info> list = new ArrayList<Info>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int d = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Info(name, d, m, y));
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1).getName());
		System.out.println(list.get(0).getName());
	}

}
