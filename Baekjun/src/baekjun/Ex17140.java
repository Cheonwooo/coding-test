package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex17140 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[3][3];
		
		for(int i=0; i<3; i++) {//초기배열 설정
			for(int j=0; j<3; j++) {
				st = new StringTokenizer(br.readLine());
				
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = 0;
		int row = 3;//행
		int col = 3;//열
		int[][] new_Arr;
		
		while(true) {
			HashMap<Integer, Integer> map;
			//1. 행>=열인 경우와
			//2. 행<열인 경우
			if(row >= col) { //행>=열인 경우
				map = new HashMap<Integer, Integer>();
				
				//초기 배열의 col || row값의 2배 되는 행 열 크기 고정
				//새로운 배열 생성을 위한 크기 구하기
				for(int i=0; i<row; i++) {
					for(int j=0; j<col; j++) {
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
					}
				}
				
				col = map.size()*2;
				if(col > 100) col = 100;//100이 넘어가는 경우 100으로 고정
				new_Arr = new int[row][col];//배열 재생성
				
				for(int i=0; i<row; i++) {
					map = new HashMap<Integer, Integer>();
					
					for(int j=0; j<col; j++) {
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
					}
					
				}
			} else { //행<열인 경우
				map = new HashMap<Integer, Integer>();
				
				//새로운 배열 생성을 위한 크기 구하기
				for(int i=0; i<row; i++) {
					for(int j=0; j<col; j++) {
						map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
					}
				}
				
				row = map.size()*2;
				if(row > 100) row = 100;//100이 넘어가는 경우 100으로 고정
				new_Arr = new int[row][col];//배열 재생성
			}
			
			
		}
		
		
	}

}
