package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex1193 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int sum = 0;
		int idx = 1;
		list.add(0);
		while(sum<=10000000) {
			sum += idx;
			list.add(sum);
			idx++;
		}
		
		for(int i=0; i<list.size()-1; i++) {
			if(x > list.get(i) && x <= list.get(i+1)) {
				if(x==list.get(i+1)) {
					int n = i+1;
					if((i+1)%2==0) {
						System.out.println(n+"/"+1);
						break;
					} else {
						System.out.println(1+"/"+n);
						break;
					}
					
				} else { 
					int n = list.get(i+1) - x;
					int f = i+1-n;
					int b = 1+n;
					if((i+1)%2==0) {
						System.out.println(f + "/" + b);
						break;
					} else {
						System.out.println(b + "/" + f);
						break;
					}
					
				}
			}
		}
	}

}
