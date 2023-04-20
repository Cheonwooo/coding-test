package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex1436 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int count = 1;
		
		while(count != N) {
			num++;
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		//666이 들어가는 수 중에서 오름차순으로 찾기
		//1~100000까지 666이 들어가는 숫자 찾기
		int i=666;
		while(list.size()!=N+1) {
			String str = String.valueOf(i);
			char[] arr = str.toCharArray();
			for(int j=0; j<arr.length-2; j++) {
				if(arr[j] == '6' && arr[j+1] == '6' && arr[j+2]=='6') {
					list.add(i);
					break;
				}
			}
			i++;
		}
		System.out.println(list.get(N-1));*/
		
		
		/*for(int i=666; i<100000; i++) {
			String str = String.valueOf(i);
			char[] arr = str.toCharArray();
			for(int j=0; j<arr.length-2; j++) {
				if(arr[j] == '6' && arr[j+1] == '6' && arr[j+2]=='6') {
					list.add(i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		System.out.println(sb);*/
		
	}

}
