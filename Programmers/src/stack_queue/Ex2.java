package stack_queue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex2 {

	public static void main(String[] args) throws IOException{
		int[] a = {95,90,99,99,80,99};
		int[] b = {1,1,1,1,1,1};
		
		System.out.println(Arrays.toString(solution(a, b)));
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        
		int[][] arr = new int[speeds.length][2];
		Queue<Pair> q = new LinkedList<>();
		
		for(int i=0; i<speeds.length; i++){//초기값 설정
			arr[i][0] = progresses[i];
			arr[i][1] = speeds[i];
			q.add(new Pair(arr[i][0], arr[i][1]));
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!q.isEmpty()){
			
			int sum = 0;
			for(int i=0; i<q.size(); i++){
				Pair now = q.poll();
				int x = now.x;
				int y = now.y;
				
				q.add(new Pair(x+y, y));
			}
			
			
			while(true){
				Pair now = q.peek();
				if(now.x<100) break;
				else if (now.x>=100) {
						sum++;
						q.poll();
						if(q.size()==0) break;
					}    
			}
			
			if(sum>0){
				list.add(sum);
			}
		}    
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
   	}
    public static class Pair{
    	int x;
    	int y;
    	public Pair(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }    	
}
