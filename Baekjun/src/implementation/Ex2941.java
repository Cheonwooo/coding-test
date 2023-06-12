package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine()
				.replaceAll("c=", "*")
				.replaceAll("c-", "*")
				.replaceAll("dz=", "*")
				.replaceAll("d-", "*")
				.replaceAll("lj", "*")
				.replaceAll("nj", "*")
				.replaceAll("s=", "*")
				.replaceAll("z=", "*");
				
		System.out.println(str.length());
	}

}
