package baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex2675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Character> arr = new ArrayList<Character>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			for(int j=0; j<str.length(); j++) {
				arr.add(str.charAt(j));
			}
			
			for(int k=0; k<arr.size(); k++) {
				for(int l=0; l<num; l++) {
					bw.write(String.valueOf(arr.get(k)));
				}
			}
			bw.newLine();
			arr.clear();
			bw.flush();
		}
		bw.close();
	}

}
