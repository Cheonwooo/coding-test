package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex17825 {
	public static int answer, max = Integer.MIN_VALUE;
	public static int[] map = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22,
								24, 26,	28, 30, 32, 34, 36, 38, 40, 0,//0~21
								10, 13, 16, 19, 25, 30, 35, 40, 0,//22~30
								20, 22, 24, 25, 30, 35, 40, 0,//31~38
								30, 28, 27, 26, 25, 30, 35, 40, 0};//39~47
	public static int[] arr, horse;
	public static HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[10];
		horse = new int[5];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<10; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] output = new int[10];
		perm(output, 0, 10);
		System.out.println(max);
	}

	public static void perm(int[] output, int depth, int r) {
		if(depth==r) {
			game(output);
			
			max = Math.max(max, answer);
			
			return;
		}
		
		for(int i=1; i<5; i++) {
			output[depth] = i;
			perm(output, depth+1, r);
		}
	}
	
	public static void game(int[] output) {
		for(int i=1; i<5; i++) {
			hash.put(i, 0);
		}
		visited = new boolean[48];
		/*
		 0~21
		 22~30
		 31~38
		 39~47
		 */
		answer = 0;
		for(int i=0; i<10; i++) {//arr의 i번째 값에 output의 i번째 말이 움직임
			int num = hash.get(output[i]);//output[i]의 위치 확인
			
			int finish = num;
			
			if(finish==47) return;
			if(map[finish] == 10) {
				visited[5] = false;
			} else if(map[finish] == 20) {
				visited[10] = false;
			} else if(finish == 15 && map[finish] == 30) {
				visited[15] = false;
			} else if(map[finish] == 25) {
				visited[26] = false;
				visited[34] = false;
				visited[43] = false;
			} else if(map[finish] == 40) {
				visited[20] = false;
				visited[29] = false;
				visited[37] = false;
				visited[46] = false;
			} else if(map[finish] == 35) {
				visited[28] = false;
				visited[36] = false;
				visited[45] = false;
			} else if(map[finish] == 30) {
				visited[27] = false;
				visited[35] = false;
				visited[44] = false;
			}
			
			for(int j=0; j<arr[i]; j++) {
				finish += 1;
				if(finish == 21 || finish == 30 || finish == 38 || finish == 47) {
					finish = 47;
					break;
				}
			}
			if(map[finish] != 0 && visited[finish]) return;//도착지점에 말이 있다면 패 버리기
			else {
				if(finish == 5) {
					visited[finish] = true;
					finish = 22;
				} else if(finish == 10) {
					visited[finish] = true;
					finish = 31;
				} else if(finish == 15) {
					visited[finish] = true;
					finish = 39;
				} else if(map[finish]==25) {
					visited[26] = true;
					visited[34] = true;
					visited[43] = true;
					finish = 26;
				} else if(map[finish]==40) {
					visited[20] = true;
					visited[29] = true;
					visited[37] = true;
					visited[46] = true;
					finish = 29;
				} else if(map[finish]==35) {
					visited[28] = true;
					visited[36] = true;
					visited[45] = true;
				} else if(map[finish]==30) {
					visited[27] = true;
					visited[35] = true;
					visited[44] = true;
				}
				visited[finish] = true;//도착지점
				answer += map[finish];
				hash.put(output[i], finish);
				visited[num] = false;//이동 전 지점
			}
		}
	}
}
