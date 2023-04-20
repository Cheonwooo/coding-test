package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2477 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] point = new int[6];
		int[] dis = new int[6];
		int max = 0;
		int maxidx = -1;
		
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			point[i] = Integer.parseInt(st.nextToken());
			dis[i] = Integer.parseInt(st.nextToken());
			
			max = (dis[i] > max) ? dis[i] : max;//max값 저장
			if(max == dis[i]) {
				maxidx = i;//max값일 때 인덱스값 저장
			}
		}
		
		leftShift(point, maxidx);
		leftShift(dis, maxidx);
		
		System.out.println(Arrays.toString(point));
		System.out.println(Arrays.toString(dis));
		
		int minsize = 0;
		int allsize = 0;
		if((dis[3]+dis[5])==dis[1]) {
			allsize = dis[0]*dis[1];
			minsize = dis[3]*dis[4];
		} else if((dis[1]+dis[3])==dis[5]){
			allsize = dis[0]*dis[5];
			minsize = dis[2]*dis[3];
		}
		System.out.println((allsize-minsize)*n);
	}
	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	private static void reverse(int[] arr, int start, int end) {
		end = end - 1;
		
		while(start < end) {
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	
	private static void leftShift(int[] arr, int n) {
		int size = arr.length;
		reverse(arr,0,n);
		reverse(arr,n,size);
		reverse(arr,0,size);
	}
	
	private static void rightShift(int[] arr, int n) {
		int size = arr.length;
		reverse(arr, size - n, size);
		reverse(arr, 0, size-n);
		reverse(arr, 0, size);
	}
	
	

}
