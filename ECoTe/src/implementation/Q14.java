package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14 {
	public static int n, answer;
	public static int[] new_dist;
	public static int[][] new_weak;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] weak = {1,5,6,10};
		int[] dist = {1,2,3,4};
		int n = 12;
		
		System.out.println(solution(n,weak, dist));
		
	}

	
	public static int solution(int n, int[] weak, int[] dist) {
		new_weak = new int[weak.length][weak.length];
		new_weak[0] = weak.clone();
		setWeak(n, weak);

		answer = dist.length + 1;
		
        perm(dist, new int[dist.length], new boolean[dist.length], 0);
        
        if(answer==dist.length+1) {
        	return -1;
        } else {
        	return answer;
        }
    }
	
	public static void setWeak(int n, int[] weak) { //weak의 모든 순환 배열
		for(int i=1; i<new_weak.length; i++) {
			int idx = i+1;
			if(idx==new_weak.length) idx = 0;
			for(int j=0; j<new_weak.length; j++) {
				if(j==0) {
					new_weak[i][j] = weak[i];
				} else {
					new_weak[i][j] = weak[idx++];
					if(idx==new_weak.length) idx = 0;
					if(new_weak[i][j-1] > new_weak[i][j]) {
						new_weak[i][j] += new_weak[i][j-1] + (n-new_weak[i][j-1]);
					}
				}
				
			}
		}
	}
	
	public static void perm(int[] dist,int[] new_dist, boolean[] visited, int depth) {
		int len = dist.length;
		
		if(depth == len) {
			check(new_weak, new_dist);
			
		}
		
		for(int i=0; i<dist.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				new_dist[depth] = dist[i];
				perm(dist, new_dist, visited, depth + 1);
				visited[i] = false;
			}
		}
	}
	
	public static void check(int[][] new_weak, int[] new_dist) {
		
		
		for(int i=0; i<new_weak.length; i++) {
			int weak_idx = 0, dist_idx = 0;
			int next = 0;
			
			while(weak_idx < new_weak[i].length && dist_idx < new_dist.length) {
				next = weak_idx + 1;
				while(next<new_weak[i].length && new_weak[i][weak_idx] + new_dist[dist_idx] >= new_weak[i][next]) {
					next++;
				}
				weak_idx = next;
				dist_idx++;
			}
			
			if(weak_idx == new_weak[i].length && dist_idx<answer) {
				answer = dist_idx;
			}
		}
		
		
	}
}
