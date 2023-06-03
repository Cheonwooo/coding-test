package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex5 {
	public static int sum, bridge_length, idx, top;
	public static Queue<Pair> q = new LinkedList<>();
	public static Queue<Integer> tq = new LinkedList<>();//트럭을 넣을 큐
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int bridge_length = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st  =new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(bridge_length,y,arr));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int cnt = 0;
		
		
		for(int i=0; i<truck_weights.length; i++) {
			tq.add(truck_weights[i]);
		}
		
		
		sum = 0;
		top = tq.peek();
		while(true) {
			
			if(top + sum <= weight) {
				
				if(q.size()!=0) {//이미 큐에 값이 있다면
					move(bridge_length, weight);
				}
				
				if(tq.size()!=0) {
					int new_t = tq.poll();
					q.add(new Pair(new_t, 1));//새로운 트럭 넣기
					sum += new_t;//sum값에 더해주기
				}
				
				
			} else {//tq.peek() + sum > weight
				move_n_input(bridge_length, weight);
			}
			
			if(tq.size()!=0) {
				top = tq.peek();
			} else {
				top = 0;
			}
			
			cnt++;

			if(tq.size()==0 && q.size()==0) {
				break;
			}
		}
		
		return cnt;
	}
	
	public static class Pair{
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void move_n_input(int bridge_length, int weight) {
		boolean check = false;
		int size = q.size();
		for(int i=0; i<size; i++) {
			Pair now = q.poll();
			
			int nx = now.x;
			int ny = now.y;
			
			if(ny+1>bridge_length) {
				check = true;
				sum -= nx;
			} else {
				q.add(new Pair(nx, ny+1));
			}
		}

		if(check && top + sum <= weight) {
			if(tq.size()!=0) {
				int new_t = tq.poll();
				q.add(new Pair(new_t, 1));
				sum += new_t;
			}
		}
		return;
	}
	
	public static void move(int bridge_length, int weight) {
		int size = q.size();
		for(int i=0; i<size; i++) {
			Pair now = q.poll();
			
			int nx = now.x;
			int ny = now.y;
			
			if(ny+1>bridge_length) {
				sum -= nx;
			} else {
				q.add(new Pair(nx, ny+1));
			}
		}
		return;
	}
}
