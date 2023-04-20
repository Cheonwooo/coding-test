package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ex10809 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		ArrayList<Character> arr = new ArrayList<Character>();
		char[] alpArr = new char[26];//알파벳 저장 배열
		int[] indexArr = new int[26];//인덱스 저장 배열
		
		for(int i=0; i<alpArr.length; i++) {//아스키코드 97~122가 소문자 a~z
			alpArr[i] = (char)(i+97);
			indexArr[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) { //각 알파벳 배열 저장
			arr.add(str.charAt(i));
		}
		
		//arr.get(i)와 알파벳 a~z까지 일치하는게 있다면 i값 저장
		//중첩반복문
		for(int j=0; j<arr.size(); j++) {
			for(int k=0; k<26; k++) {
				if(arr.get(j)==alpArr[k]) {
					if(indexArr[k]!=-1) break;
					else indexArr[k] = j;
				}
			}
		}
		
		for(int s : indexArr) {
			System.out.print(s + " ");
		}
	}
}
