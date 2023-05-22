package stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex3 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();

		
		if(solution(str)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
	}
	
	public static boolean solution(String s) {

        char[] ch = s.toCharArray();
        
        int a = 0;
        int b = 0;
        for(int i=0; i<ch.length; i++){
            if(ch[i] == '(') a++;
            else b++;
        }
        if(a!=b) {
            return false;
        } else {
        	Stack<Character> st = new Stack<Character>();
            
            st.push(ch[0]);//�ʱⰪ
            char pre = st.peek();
            for(int i=1; i<ch.length; i++){
                st.push(ch[i]);
                
                if(pre == '(' && st.peek()==')'){
                    st.pop();
                    st.pop();
                    if(st.size()!=0){
                        pre = st.peek();
                    } else {
                    	pre = ' ';
                    }
                } else{
                    pre = st.peek();
                }
                if(pre==')') break;
            }
            
            if(st.size()==0){
                return true;
            } else {
                return false;
            }
        }
    }
}
