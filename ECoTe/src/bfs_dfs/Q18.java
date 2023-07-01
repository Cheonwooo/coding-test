package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q18 {
	public static String u, v, answer, plus;
	public static Stack<Character> st; 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		System.out.println(solution(str));
	}
	
	public static String solution(String p) {
        answer = "";
        
        if(check(p)) {
        	answer = p;
        } else {
        	run(p);
        }

        return answer;
    }
	
	public static void run(String str) {
		if(str.length()==0) return;
		
		int left = 0;
		int right = 0;
		String newU = "";
		String newV = "";
		int idx = 0;
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') left++;
			else right++;
			
			if(left==right) {
				newU = str.substring(0, left+right);
				newV = str.substring(left+right);
				break;
			}
		}
		
		if(check(newU)) {
			answer += newU;
			newU = "";
			run(newV);
		} else {
			answer += "(";
			run(newV);
			answer += ")";
			if(newU.length()>2) {
				newU = newU.substring(1, newU.length()-1);
				newU = reverse(newU);
			} else {
				newU = "";
			}
			answer += newU;
		}
		
	}
	
	public static boolean check(String str) {
		st = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			if(st.isEmpty()) {
				st.push(str.charAt(i));
				continue;
			}
			if(st.peek()=='(' && str.charAt(i)==')') {
				st.pop();
			} else {
				st.push(str.charAt(i));
			}
		}
		
		if(st.isEmpty()) return true;//올바른 괄호 문자
		else return false;
		
	}
	
//	public static void sub(String str) {
//		u = "";
//		v = "";
//		int left = 0;
//		int right = 0;
//		
//		for(int i=0; i<str.length(); i++) {
//			if(str.charAt(i)=='(') left++;
//			else right++;
//			
//			if(left==right) {
//				for(int j=0; j<left+right; j++) {
//					u += str.charAt(j);
//				}
//				for(int j=left+right; j<str.length(); j++) {
//					v += str.charAt(j);
//				}
//				break;
//			}
//		}
//		return;
//	}
	
	public static String reverse(String str) {
		String re = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				re += ")";
			} else {
				re += "(";
			}
		}
		return re;
	}

}
