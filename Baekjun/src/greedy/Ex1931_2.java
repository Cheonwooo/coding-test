package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex1931_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] conf = new int[n][2];
				
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			conf[i][0] = Integer.parseInt(st.nextToken());
			conf[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(conf, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		
		Stack<Integer> s = new Stack<Integer>();
		s.add(conf[0][1]);
		
		for(int i=1; i<conf.length; i++) {
			if(s.peek() <= conf[i][0]) {
				s.add(conf[i][1]);
			}
		}
		
		System.out.println(s.size());
	}

}
