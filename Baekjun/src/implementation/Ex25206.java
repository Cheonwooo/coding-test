package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex25206 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double sum = 0;//학점*과목평점 합
		double subS = 0;//학점 합
		
		for(int i=0; i<20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String sub = st.nextToken();
			double subScore = Double.parseDouble(st.nextToken());//학점
			String str = st.nextToken();
			
			if(str.equals("P")) {
				continue;
			} else {
				double score = trans(str);//전공 평점
				sum += subScore*score;
				subS += subScore;
			}
		}
		double answer = sum/subS;
		System.out.println(String.format("%.6f", answer));
	}
	
	public static double trans(String str) {
		if(str.equals("A+")) {
			return 4.5;
		} else if(str.equals("A0")) {
			return 4.0;
		} else if(str.equals("B+")) {
			return 3.5;
		} else if(str.equals("B0")) {
			return 3.0;
		} else if(str.equals("C+")) {
			return 2.5;
		} else if(str.equals("C0")) {
			return 2.0;
		} else if(str.equals("D+")) {
			return 1.5;
		} else if(str.equals("D0")) { 
			return 1.0;
		} 
		return 0;
	}
}
