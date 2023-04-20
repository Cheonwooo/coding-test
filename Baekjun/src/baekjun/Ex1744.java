package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Ex1744 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arrP = new ArrayList<Integer>();
		ArrayList<Integer> arrM = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num > 0) { //양수
				arrP.add(num);
			} else { //0포함 음수
				arrM.add(num);
			}
		}
		
		Collections.sort(arrM);//음수는 오름차순
		Collections.sort(arrP, Collections.reverseOrder());//양수는 내림차순
		
		long sum = 0;
		int i = 0;
		
		while(i<arrP.size()) {
			if(i+1<arrP.size() && arrP.get(i) != 1 && arrP.get(i+1) != 1) { //두 원소가 둘 다 1이 아니라면 곱해줌
				sum += arrP.get(i++)*arrP.get(i++);
			} else {
				sum += arrP.get(i++);
			}
		}
		
		i=0;
		
		while(i<arrM.size()) {
			if(i+1<arrM.size()) {
				sum += arrM.get(i++)*arrM.get(i++);
			} else {
				sum += arrM.get(i++);
			}
		}
		
		System.out.println(sum);
	}

}
