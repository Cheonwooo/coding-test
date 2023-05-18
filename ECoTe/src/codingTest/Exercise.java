package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Exercise {

	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
			
		for(int i=0; i<10; i++) {
			int test_case = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int finish_x = 0;
			int finish_y = 0;
			for(int j=0; j<100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					if(arr[j][k]==2) {
						finish_x = j;
						finish_y = k;
					}
				}
			}
			int[] dx = {0, 0, -1};
			int[] dy = {-1, 1, 0};
			while(finish_x!=0) {//arr[x][0]이 될 때 까지 역으로 올라가기
				for(int j=0; j<3; j++) {
					int nx = finish_x + dx[j];
					int ny = finish_y + dy[j];
					
					if(nx<=-1 || nx>=100 || ny<=-1 || ny>=100) {
						continue;
					}
					
					if(arr[nx][ny]==1) {
						arr[nx][ny] = 0;
						finish_x = nx;
						finish_y = ny;
						break;
					}
				}
			}
			sb.append("#").append(test_case).append(" ").append(finish_y).append("\n");
		}
		System.out.println(sb);
	}
}
