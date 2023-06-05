package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Ex2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solution(arr));
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
		
		String[] nums = new String[numbers.length];
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(nums, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
				//오름차순 (o1+o2).compareTo(o1+o2), 내림차순 (o2+o1).compareTo(o1+o2)
			}
		});
		
		if(nums[0].equals("0")) return "0";
		else {
			for(int i=0; i<nums.length; i++) {			
				answer += nums[i];
			}
		}
		return answer;
	}
}
