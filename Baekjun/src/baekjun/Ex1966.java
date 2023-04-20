package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex1966 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		
		
		for(int i=0; i<n; i++) {
			int cnt = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int prt = Integer.parseInt(st.nextToken());
			int[] arr = new int[num];
			
			st = new StringTokenizer(br.readLine());
			LinkedList<int[]> q = new LinkedList<>();
			
			for(int j=0; j<num; j++){
				int addNum =Integer.parseInt(st.nextToken()); 
				q.offer(new int[] { j, addNum });
			}
			
			while(!q.isEmpty()) {
				int[] front = q.poll();
				boolean check = true;
				
				for(int k=0; k<q.size(); k++) {
					if(front[1] < q.get(k)[1]) {
						q.offer(front);
						for(int l=0; l<k; l++) {
							q.offer(q.poll());
						}
						check = false;
						break;
					}
					
				}
				if(check == false) {
					continue;
				}
				
				cnt++;
				if(front[0]==prt) {
					break;
				}
			}
			
			System.out.println(cnt);
			
			
			
		}
	}

}
