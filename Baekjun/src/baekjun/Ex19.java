package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex19 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Double> arr1 = new ArrayList<Double>();
		ArrayList<Double> arr2 = new ArrayList<Double>();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i=0; i<n; i++) {
			arr1.add(Double.parseDouble(st.nextToken()));
		}
		
		double max = arr1.get(0);
		
		for(int j=0; j<n-1; j++) { //최댓값 구하기
			max = (max>arr1.get(j+1)) ? max : arr1.get(j+1);
		}
		
		double sum = 0;
		for(int k=0; k<n; k++) {
			arr2.add(arr1.get(k)/max*100);
			sum+=arr2.get(k);
		}
		
		System.out.println(sum/n);
		
		
		
	}

}
