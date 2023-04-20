package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex1152 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<String> strArr = new ArrayList<String>();
		
		while(st.hasMoreTokens()){
			strArr.add(st.nextToken());
		}
		
		System.out.println(strArr.size());
		
	}

}
