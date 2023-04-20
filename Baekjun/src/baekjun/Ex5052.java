package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.print.DocFlavor.STRING;

public class Ex5052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		while(t!=0) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = br.readLine();
			}
			
			Arrays.sort(arr);
			
			boolean chk = false;
			for(int i=0; i<n-1; i++) {
				if(arr[i+1].startsWith(arr[i])) {
					chk = true;
					break;
				}
			}
			
			if(chk) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
			t--;
		}
	}
}