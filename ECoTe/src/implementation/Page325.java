package implementation;

public class Page325 {
	
	public static void main(String[] args) {
		int[][] key = {{0,0,1}, {0,1,0}, {0,0,1}};
		int[][] lock = {{0,1,1}, {1,0,1}, {0,1,1}};
		
		if(solution(key, lock)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		
		int len = key.length-1;
		
		for(int i=0; i<len+lock.length; i++) {
			for(int j=0; j<len+lock.length; j++) {
				for(int r=0; r<4; r++) {
					int[][] new_lock = new int[lock.length+len*2][lock.length+len*2];
					
					for(int k=0; k<lock.length; k++) {
						for(int l=0; l<lock.length; l++) {
							new_lock[len+k][len+l] = lock[k][l];
						}
					}
					
					int[][] new_key = new int[key.length][key.length];
					
					rotate(new_key, key, r);//회전
					
					for(int k=i; k<i+new_key.length; k++) {
						for(int l=j; l<j+new_key.length; l++) {
							new_lock[k][l] += new_key[k-i][l-j];
						}
					}
					if(check(new_lock, lock.length, key.length)) return true;
				}
			}
		}
		return false;
	}
	
	public static int[][] rotate(int[][] arr2,int[][] arr, int r) {
		
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				if(r==0) {//90도 회전
					arr2[i][j] = arr[arr.length-j-1][i];
				} else if(r==1) {//180도 회전
					arr2[i][j] = arr[arr.length-i-1][arr.length-j-1];
				} else if(r==2) {//270도 회전
					arr2[i][j] = arr[j][arr.length-i-1];
				} else {//360도 회전
					arr2[i][j] = arr[i][j];
				}
			}
		}
		return arr2;
	}
	
	public static boolean check(int[][] arr, int l, int k) {//l:lock.length, k:key.length
		for(int i=0; i<l; i++) {
			for(int j=0; j<l; j++) {
				if(arr[k-1+i][k-1+j]!=1) return false;
			}
		}
		return true;
	}

}
