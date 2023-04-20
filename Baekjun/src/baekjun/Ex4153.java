package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex4153 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[3];
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			if(arr[0]==0 && arr[1]==0 && arr[2]==0) {
				break;
			} else {
				if((Math.pow(arr[0], 2) + Math.pow(arr[1], 2))==(Math.pow(arr[2], 2))) {
					System.out.println("right");
				} else {
					System.out.println("wrong");
				}
			}
		}
	}

}
