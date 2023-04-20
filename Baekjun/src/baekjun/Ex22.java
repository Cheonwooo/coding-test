package baekjun;


public class Ex22 {
	
	public static int d(int n) {
		int sum = n;
		
		while(n != 0) {
			sum += n%10;
			n = n/10;
		}
		
		return sum;
	}
	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		
		for(int i=1; i<10001; i++) {
			int n = d(i);
			
			if(n<10001) {
				arr[n] = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int j=1; j<10001; j++) {
			if(!arr[j]) {
				sb.append(j).append('\n');
			}
		}
		System.out.println(sb);
	}

}
