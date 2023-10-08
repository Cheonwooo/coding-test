package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13458 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		for(int i=0; i<n; i++) {
			if(arr[i]-b <= 0) {
				cnt++;
			} else {
				cnt++;
				
				int num = arr[i]-b;
				
				int stu = num/c;
				if(num%c!=0) {
					stu += 1;
				}
				
				cnt += stu;
			}
		}
		System.out.println(cnt);
	}

}
