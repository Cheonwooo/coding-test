package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;


public class Ex1339 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[26];//A~Z까지의 가중치를 더해줄 배열
		
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				arr[str.charAt(j)-65]+=Math.pow(10, str.length()-1-j);
				System.out.println(arr[str.charAt(j)-65] + " " );
			}
		}
		
		Arrays.sort(arr);
		
		int cnt = 9;
		int sum = 0;
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i]!=0) {
				sum+=arr[i]*cnt;
				cnt--;
			}
		}
		System.out.println(sum);
		/*int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][8];//10x8배열 생성
		int[][] new_Arr = new int[n][8];
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(char i='A'; i<='Z'; i++) {
			map.put(i, -1);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<8; j++) {
				arr[i][j]='a';
			}
		}
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			int k=1;
			for(int j=7; j>7-str.length(); j--, k++) {
				arr[i][j] = str.charAt(str.length()-k);
			}
		}
		
		
		
		int cnt = 9;
		for(int i=0; i<8; i++) {
			for(int j=0; j<n; j++) {
				if(arr[j][i]!='a') {//이미 값이 존재한다면 또는 값이 존재하지 않는다면
					if(map.get(arr[j][i])==-1){//해당 값이 존재하지 않는다면
						new_Arr[j][i]=cnt;
						map.put(arr[j][i], cnt);
						cnt--;
					} else {//해당 값이 존재한다면
						new_Arr[j][i] = map.get(arr[j][i]);
					}
				}
			}
		}
		
		int sum = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<8; j++) {
				sum += new_Arr[i][j]*Math.pow(10, 7-j);
			}
		}
		System.out.println(sum);
		for(int i=0; i<n; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(new_Arr[i][j] + " ");
			}
			System.out.println();
		}*/
	}

}
