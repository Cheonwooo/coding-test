package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int r = Integer.parseInt(br.readLine());
		int[][] commands = new int[r][3];
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			
			commands[i][0] = Integer.parseInt(st.nextToken());
			commands[i][1] = Integer.parseInt(st.nextToken());
			commands[i][2] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Arrays.toString(solution(arr, commands)));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for(int i=0; i<commands.length; i++) {
			int stidx = commands[i][0]-1;
			int endidx = commands[i][1]-1;
			int idx = commands[i][2]-1;
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j=stidx; j<endidx+1; j++) {
				
				
				list.add(array[j]);
			}
			
			Collections.sort(list);
			
			answer[i] = list.get(idx);
		}
		
		return answer;
	}
}
