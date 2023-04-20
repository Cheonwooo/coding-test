package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex1339 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int sum = 0;
		for(int i=0; i<50; i++) {//랜덤 숫자 생성
			list.add((int)(Math.random()*50));
			sum += list.get(i);
			System.out.print(list.get(i) + " ");
		}

		int val = sum/50;
		
		System.out.println();
		System.out.println("평균값 : " + val);
		
		boolean check = false;//평균값과 같은 랜덤 숫자가 없으면 false, 있으면 true
		for(int i : list) {
			if(i==val){
				check = true;
				System.out.println(i);
				break;
			} 
		}
		if(!check) {
			System.out.println(0);
		}
	}

}
