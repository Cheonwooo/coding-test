package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex1427 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] cnt = new int[10];
		String num = br.readLine();
		
		for(int i=0; i<num.length(); i++) {
			cnt[num.charAt(i) - '0']++;
		}
		
		for(int i=9; i>=0; i--) {
			while(cnt[i]-->0) {
				System.out.print(i);
			}
		}
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String num = br.readLine();//수 입력받음
		//입력 받은 수를 각자리수 마다 배열에 넣기
		
		int[] arr = new int[num.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)num.charAt(i) - '0';
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]<arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);*/
	}

}
