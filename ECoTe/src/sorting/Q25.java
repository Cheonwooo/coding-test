package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q25 {
	public static ArrayList<Game> list = new ArrayList<Game>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int num = Integer.parseInt(br.readLine());
		int[] stages = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<num; i++) {
			stages[i] = Integer.parseInt(st.nextToken());
		}
		solution(N, stages);
		
		
	}
	
	public static int[] solution(int N, int[] stages) {
        
        int[] count = new int[N+1];//스테이지에 도달한 총 명수
        int[] noclear = new int[N+1];//스테이지에 도달했는데 클리어 하지 못한 명수
        
        Arrays.sort(stages);
        
        for(int i=1; i<N+1; i++) {
        	for(int j=0; j<stages.length; j++) {
        		if(i <= stages[j]) {
        			count[i]++;
        		}
        		if(i==stages[j]) {
        			noclear[i]++;
        		}
        	}
        }

        for(int i=1; i<N+1; i++) {
        	if(count[i]==0) {
        		list.add(new Game(0, i));
        	} else {
        		list.add(new Game((double)noclear[i]/count[i], i));
        	}
        	
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).stage;
            System.out.println(answer[i]);
        }

        return answer;
    }
	public static class Game implements Comparable<Game>{
		double rate;
		int stage;
		
		public Game(double rate, int stage) {
			this.rate = rate;
			this.stage = stage;
		}
		
		public int compareTo(Game other) {
			if(this.rate == other.rate) {
				return Integer.compare(this.stage, other.stage);
			}
			return Double.compare(other.rate, this.rate);
		}
	}
}
