package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1213 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] arr = new int[26];//A:0 ~ Z:25
		
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i)-'A']++;
		}
		
		String result = "";
		boolean check = false;
		if(str.length()%2==0) {//Â¦¼ö¶ó¸é
			for(int i=0; i<arr.length; i++) {
				if(arr[i]%2!=0) {
					check = true;
				} else if(arr[i]!=0 && arr[i]%2==0){
					arr[i] /=2;
					for(int j=0; j<arr[i]; j++) {
						result += (char)(i+'A');
					}
				}
			}
			StringBuffer sb = new StringBuffer(result);
			String reverse = sb.reverse().toString();
			result += reverse;
		} else {//È¦¼ö¶ó¸é
			int cnt = 0;
			int save = 0;//È¦¼öÀÎ ¾ËÆÄºªÀ» ÀúÀå
			for(int i=0; i<arr.length; i++) {
				if(arr[i]%2!=0) {//È¦¼ö¶ó¸é
					cnt++;
					arr[i] -= 1;
					save = i;
				}
			}
			if(cnt==0 || cnt>=2) {
				check = true;
			} else {
				for(int i=0; i<arr.length; i++) {
					if(arr[i]!=0 && arr[i]%2==0) {
						arr[i] /= 2;
						for(int j=0; j<arr[i]; j++) {
							result += (char)(i+'A');
						}
					}
				}
				StringBuffer sb = new StringBuffer(result);
				String reverse = sb.reverse().toString();
				result += (char)(save+'A')+reverse;
			}
		}
		if(check) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			System.out.println(result);
		}
		
	}

}
