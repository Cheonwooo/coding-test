package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19 {
	public static long max = Integer.MIN_VALUE;
	public static long min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] oper = new String[n-1];//연산자
		String[] output = new String[n-1];//연산자 순열
		int[] operator = new int[4];
		boolean[] visited = new boolean[n-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			
			operator[i] = Integer.parseInt(st.nextToken());
			
			if(operator[i]==0) continue;
			
			for(int j=0; j<operator[i]; j++, idx++) {
				if(i==0) {
					oper[idx] = "+";
				} else if(i==1) {
					oper[idx] = "-";
				} else if(i==2) {
					oper[idx] = "*";
				} else {
					oper[idx] = "/";
				}

			}
		}
		
		cal(arr, oper, output, visited, 0, n-1, n-1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void cal(int[] arr, String[] oper, String[] output, boolean[] visited, int depth, int n, int r) {
		if(depth == r) {
			String[] calc = new String[(2*arr.length)-1];
			calc[0] = String.valueOf(arr[0]);
			int idx = 1;
			int operIdx = 0;
			for(int i=1; i<calc.length; i++) {
				 if(i%2!=0) {//홀수라면
					 calc[i] = output[operIdx];
					 operIdx++;
				 } else { //짝수라면
					 calc[i] = String.valueOf(arr[idx]);
					 idx++;
				 }
			}
			
			long num = check(calc);
			
			max = Math.max(max, num);
			min = Math.min(min, num);
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = oper[i];
				cal(arr, oper, output, visited, depth+1, n, r);
				visited[i] = false;
			}
		}
	}
	
	public static long check(String[] str) {
		long sum = 0;
		for(int i=1; i<str.length-1; i++) {
			if(str[i].equals("+")) {
				if(i==1) {
					sum = Integer.parseInt(str[i-1]) + Integer.parseInt(str[i+1]);
				} else {
					sum += Integer.parseInt(str[i+1]);
				}
			} else if(str[i].equals("-")) {
				if(i==1) {
					sum = Integer.parseInt(str[i-1]) - Integer.parseInt(str[i+1]);
				} else {
					sum -= Integer.parseInt(str[i+1]);
				}
			} else if(str[i].equals("*")) {
				if(i==1) {
					sum = Integer.parseInt(str[i-1]) * Integer.parseInt(str[i+1]);
				} else {
					sum *= Integer.parseInt(str[i+1]);
				}
			} else if(str[i].equals("/")){
				if(i==1) {
					if(Integer.parseInt(str[i-1]) < 0) {//음수라면 양수로 바꿔 계산한 후 다시 음수로 변경
						sum = ((-1)*Integer.parseInt(str[i-1]) / Integer.parseInt(str[i+1]))*(-1);
						
					} else {
						sum = Integer.parseInt(str[i-1]) / Integer.parseInt(str[i+1]);
					}
				} else {
					if(sum < 0) {//음수라면 양수로 바꿔 계산한 후 다시 음수로 변경
						sum = (sum*(-1) / Integer.parseInt(str[i+1]))*(-1);
					} else {
						sum = sum / Integer.parseInt(str[i+1]);
					}
				}
			}
		}
		
		return sum;
	}
}
