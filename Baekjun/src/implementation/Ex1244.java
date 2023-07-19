package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1244 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int gen = Integer.parseInt(st.nextToken());//1:��, 2:��
			int idx = Integer.parseInt(st.nextToken());
			
			if(gen==1) {
				for(int j=1; j<arr.length; j++) {
					if(j%idx==0) {//j�� idx�� ������ ���°� ����
						arr[j] = change(arr[j]);
					}
				}
				
			} else {//������ ��
				
				int d = 1;
				
				arr[idx] = change(arr[idx]);//idx�� ���� ����ġ�� ������ �ٲ�
				while(true) {
					if(idx-d<=0 || idx+d>n || arr[idx-d]!=arr[idx+d]) break;
					if(idx-d>0 && idx+d<=n && arr[idx-d]==arr[idx+d]) {//��Ī�� �̶��
						arr[idx-d] = change(arr[idx-d]);
						arr[idx+d] = change(arr[idx+d]);
					}
					d++;
				}
			}
		}
		
		for(int i=1; i<arr.length; i++) {
			if(i>20 && i%20==1) System.out.println();
			System.out.print(arr[i]+ " ");
		}
	}
	public static int change(int x) {
		if(x==1) {
			return 0;
		}
		return 1;
	}

}
