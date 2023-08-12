package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex2331 {
	public static int idx;
	public static ArrayList<Integer> list = new ArrayList<Integer>(); 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		list.add(a);
		
		while(true) {
			int sum = 0;
			int num = list.get(list.size()-1);

			while(num!=0){
				sum += Math.pow(num%10,p);
				num/=10;
			}
			
			if(list.contains(sum)) {
				System.out.println(list.indexOf(sum));
				break;
			} else {
				list.add(sum);
			}

		}
	}
	
}
