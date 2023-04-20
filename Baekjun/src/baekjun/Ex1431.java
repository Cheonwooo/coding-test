package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ex1431 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<n; i++) {
			String serial = br.readLine();
			map.put(serial, serial.length());
		}
		
		List<String> listArr = new ArrayList<String>(map.keySet());
		
		Collections.sort(listArr, (o1, o2) -> {
			if(map.get(o1)==map.get(o2)) {//길이가 같다면
				int sum1, sum2 = 0;
				//숫자만 추출
				String str1 = (String)o1;
				String str2 = (String)o2;
				
				sum1 = subStr(str1);
				sum2 = subStr(str2);
				
				if(sum1 < sum2) {
					return -1;
				} else if(sum1 > sum2) {
					return 1;
				} else { // 같을 경우
					return ((Comparable)o1).compareTo(o2);
				}
			} else { //길이가 다르다면
				return map.get(o1).compareTo(map.get(o2));
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(String ans : listArr) {
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int subStr(String str) {
		int sum = 0;
		String str1 = str.replaceAll("[^\\d]", "");
		ArrayList<Integer> list = new ArrayList<Integer>();
		char[] charArr = str1.toCharArray();
		
		for(int i=0; i<charArr.length; i++) {
			list.add(Integer.parseInt(String.valueOf(charArr[i])));
			sum += list.get(i);
		}
		
		return sum;
	}
}
