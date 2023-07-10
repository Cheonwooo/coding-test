package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class Q23 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Grade> list = new ArrayList<Grade>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			
			list.add(new Grade(name, kor, eng, math));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i).name).append("\n");
		}
		System.out.println(sb);
	}
	
	public static class Grade implements Comparable<Grade>{
		String name;
		int kor;
		int eng;
		int math;
		
		public Grade(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public int compareTo(Grade other) {
			if(this.kor == other.kor && this.eng == other.eng && this.math == other.math) {
				return this.name.compareTo(other.name);
			}
			if(this.kor == other.kor && this.eng == other.eng) {
				return Integer.compare(other.math, this.math);
			}
			if(this.kor == other.kor) {
				return Integer.compare(this.eng, other.eng);
			}
			return Integer.compare(other.kor, this.kor);
		}
	}
}
