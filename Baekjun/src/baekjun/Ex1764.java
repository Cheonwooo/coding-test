package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Ex1764 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			map.put(str, 0);
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> nameList = new ArrayList<String>();
		int cnt = 0;
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if(map.containsKey(name)) {
				cnt++;
				nameList.add(name);
			}
		}
		nameList.sort(Comparator.naturalOrder());
		/*String[] list = new String[cnt];
		for(int i=0; i<cnt; i++) {
			list[i] = nameList.get(i);
		}
		
		Arrays.sort(list);*/
		
		for(int i=0; i<nameList.size(); i++) {
			sb.append(nameList.get(i)).append('\n');
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

}
