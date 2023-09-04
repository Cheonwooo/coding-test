package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Ex16637 {
	public static ArrayList<String> list;
	public static int n, k, max;
	public static String[] str;
	public static boolean[] visited;
	public static int[] output;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		str = br.readLine().split("");
		k = n/2;//특수부호의 개수
		max = Integer.MIN_VALUE;
		if(str.length==1) {
			System.out.println(Integer.parseInt(str[0]));
		} else if(str.length==3) {
			int real = 0;
			if(str[1].equals("+")){
				real = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
			} else if(str[1].equals("-")) {
				real = Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
			} else if(str[1].equals("*")) {
				real = Integer.parseInt(str[0]) * Integer.parseInt(str[2]);
			}
			System.out.println(real);
		} else if(str.length > 3) {
			for(int i=1; i<k+1; i++) {
				visited = new boolean[k];
				output = new int[i];
				
				comb(visited, output, 0, 0, i);
			}
			System.out.println(max);
		}
		
		
	}
	
	public static void comb(boolean[] visited, int[] output, int start, int depth, int r) {
		if(depth==r) {
			list = new ArrayList<String>();
			cal(output);
			return;
		}
		
		for(int i=start; i<k; i++) {
			if(!visited[i])
				if(i==0) {
					visited[i] = true;
					visited[i+1] = true;
					output[depth] = i;
					comb(visited, output, i, depth+1, r);
					visited[i] = false;
					visited[i+1] = false;
				} else if(i==k-1) {
					visited[i-1] = true;
					visited[i] = true;
					output[depth] = i;
					comb(visited, output, i, depth+1, r);
					visited[i-1] = false;
					visited[i] = false;
				} else {
					visited[i-1] = true;
					visited[i] = true;
					visited[i+1] = true;
					output[depth] = i;
					comb(visited, output, i, depth+1, r);
					visited[i-1] = false;
					visited[i] = false;
					visited[i+1] = false;
				}
		}
	}
	
	public static void cal(int[] output) {
		boolean[] check = new boolean[n];
		for(int i=0; i<output.length; i++) {
			check[2*output[i]+1] = true;
			
		}
		
		
		Queue<String> q = new LinkedList<>();
		for(int i=0; i<str.length; i++) {
			q.offer(str[i]);
		}
		
		Deque<String> dq = new LinkedList<>();
		int idx = 0;
		while(!q.isEmpty()) {
			if(check[idx]) {//check[i]가 true인 경우는 선택된 특수기호뿐
				int a = Integer.parseInt(dq.pollLast());
				String cul = q. poll();
				int b = Integer.parseInt(q.poll());
				
				String sum = "";
				if(cul.equals("+")) {
					sum = String.valueOf(a+b);
				} else if(cul.equals("-")) {
					sum = String.valueOf(a-b);
				} else if(cul.equals("*")) {
					sum = String.valueOf(a*b);
				}
				dq.offer(sum);
				idx += 2;
			} else {
				dq.offer(q.poll());
				idx++;
			}			
		}
		
		int answer = 0;
		while(!dq.isEmpty()) {
			String now = dq.poll();
			list.add(now);
		}
		
		for(int i=0; i<list.size()-1; i++) {
			if(i==1) {
				if(list.get(i).equals("+")) {
					answer = Integer.parseInt(list.get(i-1))+Integer.parseInt(list.get(i+1));
				} else if(list.get(i).equals("-")) {
					answer = Integer.parseInt(list.get(i-1))-Integer.parseInt(list.get(i+1));
				} else if(list.get(i).equals("*")) {
					answer = Integer.parseInt(list.get(i-1))*Integer.parseInt(list.get(i+1));
				}
			} else if(i%2!=0) {
				if(list.get(i).equals("+")) {
					answer += Integer.parseInt(list.get(i+1));
				} else if(list.get(i).equals("-")) {
					answer -= Integer.parseInt(list.get(i+1));
				} else if(list.get(i).equals("*")) {
					answer *= Integer.parseInt(list.get(i+1));
				}
			}
		}
		max = Math.max(max, answer);
	}
}
