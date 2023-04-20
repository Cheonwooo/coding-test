package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2869 {

	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[3];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		if(((arr[2]-arr[0])%(arr[0]-arr[1]))==0) {
			System.out.println(((arr[2]-arr[0])/(arr[0]-arr[1]))+1);
		} else {
			System.out.println(((arr[2]-arr[0])/(arr[0]-arr[1]))+2);
		}
		
		/*7 4 30
		30 - 7 = 23
		23을 7-4로 나누면 몫은 7
		1 7 3
		2 10 6
		3 13 9
		4 16 12
		5 19 15
		6 22 18
		7 25 21
		8 28 24
		9 31 
		
		5 2 35
		35 - 5 = 30
		30을 5-2로 나누면 몫은 10
		1 5 3
		2 8 6
		3 11 9
		4 14 12
		5 17 15
		6 20 18
		7 23 21
		8 26 24
		9 29 27
		10 32 30
		11 35
		5 - 2 = 3
		3을 2-1로 나누면 3
		
		6 - 5 = 1
		1을 6-5로 나누면 1
		8 3 40
		40 - 8 = 32
		32를 8-3으로 나누면 몫은 6
		1 8 5
		2 13 10
		3 18 15
		4 23 20
		5 28 25
		6 33 30
		7 38 35
		8 43 */
			
	}

}
