package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Ex17140 {
	public static int r, c, k, rowNum, colNum;
	public static int[][] arr = new int[100][100];
	public static HashMap<Integer, Integer> map;
	public static List<Entry<Integer, Integer>> list; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		//초기배열 설정
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//초기값
		rowNum = 3;
		colNum = 3;
		
		int cnt = 0;
		while(true) {//(r,c)가 k일 때까지
			/*System.out.println();
			for(int i=0; i<rowNum; i++) {
				for(int j=0; j<colNum; j++) {
					System.out.print(arr[i][j] + " " );
				}
				System.out.println();
			}*/
			if(check()) break;
			else {
				remod(arr, rowNum, colNum);
				cnt++;
				if(cnt==101) {
					cnt=-1;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean check() {
		if(arr[r-1][c-1]==k) {
			return true;
		}
		return false;
	}
	
	public static void remod(int[][] arr, int x, int y) {
		if(x>=y) {//R연산
			colNum = Integer.MIN_VALUE;
			for(int i=0; i<x; i++) {
				map = new HashMap<Integer, Integer>();
				for(int j=0; j<y; j++) {
					if(arr[i][j]==0) continue;
					map.put(arr[i][j], map.getOrDefault(arr[i][j], 0)+1);
					arr[i][j]=0;
				}
				colNum = Math.max(colNum, map.size()*2);
				
				sorted();
				
				int idx = 0;
				for(Entry<Integer, Integer> v : list) {
					arr[i][idx] = v.getKey();
					arr[i][idx+1] = v.getValue();
					idx+=2;
					if(idx>=100) break;
				}
			}
		} else {//C연산
			rowNum = Integer.MIN_VALUE;
			for(int i=0; i<y; i++) {
				map = new HashMap<Integer, Integer>();
				for(int j=0; j<x; j++) {
					if(arr[j][i]==0) continue;
					map.put(arr[j][i], map.getOrDefault(arr[j][i], 0)+1);
					arr[j][i]=0;
				}
				rowNum = Math.max(rowNum, map.size()*2);
				
				sorted();
				
				int idx = 0;
				for(Entry<Integer, Integer> v : list) {
					arr[idx][i] = v.getKey();
					arr[idx+1][i] = v.getValue();
					idx+=2;
					if(idx>=100) break;
				}
			}
		}
	}
	
	public static void sorted() {
		
		list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Integer, Integer>> (){//map(list) 정렬
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue() == o2.getValue()) {
					return o1.getKey() - o2.getKey();
				} else {
					return o1.getValue() - o2.getValue();
				}
			}
		});
	}
}

