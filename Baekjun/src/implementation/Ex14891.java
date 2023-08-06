package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex14891 {
	public static int[][] arr, map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[4][8];
		map = new int[4][8];
		for(int i=0; i<4; i++) {
			String[] str = br.readLine().split("");
			
			for(int j=0; j<8; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				arr[i][j] = map[i][j];
			}
		}
		
		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			
			int cnt = 1;
			if(num==0) {
				for(int j=0; j<3; j++) {
					if(arr[j][2]==arr[j+1][6]) break;
					else cnt++;
				}
				for(int j=0; j<cnt; j++) {//1개면 2, 2개면 3, 3개면 4
					turn(num+j, d);
					d*=(-1);
				}
			} else if(num==1) {
				int temp = d;
				for(int j=1; j<3; j++) {
					if(arr[j][2]==arr[j+1][6]) break;
					else cnt++;
				}
				if(arr[0][2]!=arr[1][6]) {
					turn(0, d*(-1));
				}
				for(int j=0; j<cnt; j++) {
					turn(num+j, d);
					d*=(-1);
				}		
				
			} else if(num==2) {
				int temp = d;
				for(int j=2; j>0; j--) {
					if(arr[j][6]==arr[j-1][2]) break;
					else cnt++;
				}
				if(arr[2][2]!=arr[3][6]) {
					turn(3, d*(-1));
				}
				for(int j=0; j<cnt; j++) {
					turn(num-j, d);
					d*=(-1);
				}
				
			} else if(num==3) {
				for(int j=3; j>0; j--) {
					if(arr[j][6] == arr[j-1][2]) break;
					else cnt++;
				}
				for(int j=0; j<cnt; j++) {
					turn(num-j, d);
					d*=(-1);
				}
			}
//			for(int j=0; j<4; j++) {
//				for(int k=0; k<8; k++) {
//					System.out.print(arr[j][k]);
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		int answer = 0;
		
		if(arr[0][0]==1) answer+=1;
		if(arr[1][0]==1) answer += 2;
		if(arr[2][0]==1) answer += 4;
		if(arr[3][0]==1) answer += 8;
		
		System.out.println(answer);
	}
	
	public static void turn(int num, int d) {
		if(d==1) {//시계방향
			int temp = arr[num][7];
			for(int i=0; i<8; i++) {
				if(i==7) {
					arr[num][0] = temp; 
				} else {
					arr[num][7-i] = arr[num][7-i-1];
				}
			}
		} else {//d==-1
			int temp = arr[num][0];
			for(int i=7; i>=0; i--) {
				if(i==0) {
					arr[num][7] = temp;
				} else {
					arr[num][7-i] = arr[num][7-i+1];
				}
			}
		}
	}

}
//11 0 01 1 00
//00 0 01 1 01
//11 0 00 1 00
//11 0 10 0 01
//10
//3 1
//1 -1
//3 1
//2 -1
//3 1
//2 -1
//4 1
//1 1
//3 1
//2 -1
