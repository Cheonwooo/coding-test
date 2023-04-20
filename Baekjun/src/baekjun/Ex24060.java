package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex24060 {
	static int[] sorted;
	static int K;
	static int cnt = 0;
	static int result = -1;
	public static void merge_sort(int[] a,int p, int r) {
		if(cnt > K) return;
		int q;
		if(p < r) {
			q = (p + r) / 2;
			merge_sort(a, p, q);
			merge_sort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	public static void merge(int[] a, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;
		
		while(i<=q && j<=r) {
			if(a[i]<=a[j]) {
				sorted[t] = a[i];
				t++;
				i++;
			} else {
				sorted[t] = a[j];
				t++;
				j++;
			}
		}
		
		while(i<=q) {
			sorted[t] = a[i];
			t++;
			i++;
		}
		while(j<=r) {
			sorted[t] = a[j];
			t++;
			j++;
		}
		i = p; t = 0;
		while(i<=r) {
			cnt++;
			if(cnt==K) {
				result = sorted[t];
				break;
			}
			a[i++] = sorted[t++];
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		K = Integer.parseInt(st1.nextToken());
		int[] arr = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		sorted = new int[N];
		
		merge_sort(arr, 0, N-1);
		System.out.println(result);
		
	}

}
