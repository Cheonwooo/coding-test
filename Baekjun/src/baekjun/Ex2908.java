package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2908 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] num = new String[2];
		char[] arr1 = new char[3];
		char[] arr2 = new char[3];
		int[] numArr = new int[2];
		
		while(st.hasMoreTokens()) {
			num[0] = st.nextToken();
			num[1] = st.nextToken();
		}
		
		for(int i=0; i<3; i++) {
			arr1[i] = num[0].charAt(2-i);
			arr2[i] = num[1].charAt(2-i);
		}
		//순서가 바뀐 숫자 String형으로 저장
		num[0] = new String(arr1);
		num[1] = new String(arr2);
		
		numArr[0] = Integer.parseInt(num[0]);
		numArr[1] = Integer.parseInt(num[1]);
		
		if(numArr[0] > numArr[1]) System.out.println(numArr[0]);
		else System.out.println(numArr[1]);
	}

}
