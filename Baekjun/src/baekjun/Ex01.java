package baekjun;

public class Ex01 {
	static int sum = 0;
	
	public static void d(int num) {
		
		sum = num + num/10 + num%10;
	}
	public static void main(String[] args) {
		int count=0;
		int[] arr1 = new int[10000];
		
		
		for(int i=0; i<10000; i++) {
			arr1[i]=i+1;
		}
		
		for(int i=1; sum<10000; i++) {
			d(i);
			count++;
		}
		int[] arr2 = new int[count];
		for(int i=0; sum<10000; i++) {
			d(i);
			arr2[i] = sum; 
		}
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i]!=arr2[j]) {
					System.out.println(arr1[i]);
				}
			}
		}
	}

}
