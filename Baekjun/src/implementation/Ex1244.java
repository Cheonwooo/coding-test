package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1244 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gen = Integer.parseInt(st.nextToken());//1:남, 2:여
			int idx = Integer.parseInt(st.nextToken());
			
			if(gen==1) {
				for(int j=1; j<arr.length; j++) {
					if(j%idx==0) {//j가 idx의 배수라면 상태값 변경
						arr[j] = change(arr[j]);
					}
				}
				
			} else {//여자일 때
				
				int d = 1;
				
				arr[idx] = change(arr[idx]);//idx의 전구 스위치는 무조건 바뀜
				while(true) {
					if(idx-d<=0 || idx+d>n || arr[idx-d]!=arr[idx+d]) break;
					if(idx-d>0 && idx+d<=n && arr[idx-d]==arr[idx+d]) {//대칭이 이라면
						arr[idx-d] = change(arr[idx-d]);
						arr[idx+d] = change(arr[idx+d]);
					}
					d++;
				}
			}
		}
		
		for(int i=1; i<arr.length; i++) {
			if(i>20 && i%20==1) System.out.println();
			System.out.print(arr[i]+ " ");
		}
	}
	public static int change(int x) {
		if(x==1) {
			return 0;
		}
		return 1;
	}

}
