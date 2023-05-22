package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Ex1 {
	public static Queue<Integer> q = new LinkedList<>(); 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = {1,1,3,3,0,1,1};
		
		System.out.println(Arrays.toString(solution(arr)));
	}

	public static int[] solution(int []arr) {
		
        q.add(arr[0]);
        int peek = arr[0];
        for(int i=1; i<arr.length; i++){
            if(peek==arr[i]){//앞의 값과 같다면 패스
                continue;
            } else{//앞의 값과 다르다면
                q.add(arr[i]);
                peek = arr[i];
            }
        }
        int[] answer = new int[q.size()];
        
        int idx = 0;
        while(!q.isEmpty()){
            answer[idx] = q.poll();
            idx++;
        }
        return answer;
           
    }
}
