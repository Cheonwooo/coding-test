package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4659 {
	public static char[] c = {'a', 'e', 'i', 'o', 'u'}; 

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			if(str.equals("end")) break;
			boolean check = game(str);			
			if(check) {
				sb.append("<").append(str).append("> is acceptable.").append("\n");
			} else {
				sb.append("<").append(str).append("> is not acceptable.").append("\n");
			}
			
		}
		System.out.println(sb);
		
	}
	
	public static boolean game(String str) {
		char[] cArr = str.toCharArray();
		//1.������ �ִ��� ������ Ȯ��
		
			if(!mo(str)) return false;
		
			for(int i=2; i<str.length(); i++) {
				char ch = str.charAt(i);
				if(ismo(ch)) {
					if(ismo(str.charAt(i-2)) && ismo(str.charAt(i-1))) {
						return false;
					}
				} else {
					if(!ismo(str.charAt(i-2)) && !ismo(str.charAt(i-1))) {
						return false;
					}
				}
			}
			//2.���� ���ڰ� ���������� �ι� ������(e, o����) 
			
			for(int i=0; i<str.length()-1; i++) {
				char ch = str.charAt(i);
				if(ch==str.charAt(i+1)) {
					if(ch!='e' && ch!='o') {
						return false;	
					}
				}
			}
		return true;
		//3.������ 3�� Ȥ�� ������ 3�� �������� ��������
		
	}
	
	public static boolean mo(String s) {
		boolean check = false;
		if(s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
			
			check = true;
		}
		return check;
	}
	public static boolean ismo(char c) {
		boolean check = false;
		if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') check = true;
		return check;
		
	}
}
