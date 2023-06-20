package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String[] word = str.replaceAll("[0-9]", "").split("");
		String[] num = str.replaceAll("[^0-9]", "").split("");
		int[] n = new int[num.length];
		
		int sum = 0;
		for(int i=0; i<num.length; i++) {
			n[i] = Integer.parseInt(num[i]);
			sum += n[i];
		}
		
		Arrays.sort(word);
		
		String answer = "";
		
		for(String s : word) {
			answer += s;
		}
		
		System.out.println(answer + sum);
		
	}

}
