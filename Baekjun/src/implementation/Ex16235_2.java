package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex16235_2 {
	public static class Tree implements Comparable<Tree>{
		int x;
		int y;
		int age;
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		
		public final int getX() {
			return x;
		}


		public final int getY() {
			return y;
		}


		public final int getAge() {
			return age;
		}


		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	
	public static int n, m, k;
	public static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	public static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	public static int[][] food, A;
	public static Deque<Tree> tree;
	public static Queue<Tree> dieTree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		food = new int[n+1][n+1];
		A = new int[n+1][n+1];
		tree = new LinkedList<>();
		
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				food[i][j] = 5;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			tree.add(new Tree(x, y, age));
		}
		
		while(k!=0) {
			k--;
			
			spring();
			summer();
			autumn();
			winter();
		}
		
		System.out.println(tree.size());
	}
	
	public static void spring() {
		dieTree = new LinkedList<>();
		int size = tree.size();
		for(int i=0; i<size; i++) {
			Tree cur = tree.poll();
			
			if(cur.getAge() <= food[cur.getX()][cur.getY()]) {
				food[cur.getX()][cur.getY()] -= cur.getAge();
				cur.age++;
				tree.add(cur);
			} else {
				dieTree.add(cur);
			}
		}
	}
	
	public static void summer() {
		while(!dieTree.isEmpty()) {
			Tree cur = dieTree.poll();
			
			food[cur.getX()][cur.getY()] += cur.getAge()/2;
		}
	}
	
	public static void autumn() {
		Queue<Tree> q = new LinkedList<>();
		
		for(Tree t : tree) {
			if(t.age%5 == 0) {
				q.add(t);
			}
		}
		
		while(!q.isEmpty()) {
			Tree cur = q.poll();
			
			for(int i=0; i<8; i++) {
				int nx = cur.getX() + dx[i];
				int ny = cur.getY() + dy[i];
				
				if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
					tree.addFirst(new Tree(nx, ny, 1));
				}
			}
		}
	}
	
	public static void winter() {
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				food[i][j] += A[i][j];
			}
		}
	}

}
