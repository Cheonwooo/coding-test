package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10250 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[] arr= new int[3];
		
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			for(int j=0; j<arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			if(arr[2]<arr[0]) {
				System.out.println(arr[2]+ "01");
			} else if(arr[2]>=arr[0]) {
				if(arr[2]%arr[0]==0) {//arr[2]가 arr[0]의 배수라면
					if((arr[2]/arr[0])<10) { //호수가 10보다 작을 경우 0Y호 붙어야함
						System.out.println(arr[0]+"0"+(arr[2]/arr[0]));
					} else {
						System.out.println(arr[0]+""+(arr[2]/arr[0]));
					}
				} else { //arr[2]가 arr[0]의 배수가 아니라면
					if(arr[2]/arr[0]<9) {//호수가 10보다 작을 경우
						System.out.println((arr[2]%arr[0])+"0"+((arr[2]/arr[0])+1));
					} else {//호수가 10보다 클 경우
						System.out.println((arr[2]%arr[0])+""+((arr[2]/arr[0])+1));
					}
				}
			}
		}
	}

}
