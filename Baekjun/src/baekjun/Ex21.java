package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex21 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int count = 0;
			double sum = 0;
			double avg = 0;
			double ratio = 0;
			
			while(st.hasMoreTokens()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int j=1; j<arr.size(); j++) { //점수 합 구하기
				sum+=arr.get(j);
			}
			avg = sum/(double)arr.get(0);
			
			for(int k=1; k<arr.size(); k++) {
				if(arr.get(k)>avg) 
					count++;
			}
			
			ratio = (count/(double)arr.get(0))*100;
			
			String str = String.format("%.3f", ratio);
			System.out.println(str + "%");
			arr.clear();
		}
	}

}
