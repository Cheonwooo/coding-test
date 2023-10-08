package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex16935 {
	public static int n, m;
	public static int[][] arr, temp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			
			start(num);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(arr[i][j] + " " );
			}System.out.println();
		}System.out.println();
	}
	public static void start(int num) {
		if(num==1) {
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<m; j++) {
					int temp = arr[i][j];
					arr[i][j] = arr[n-1-i][j];
					arr[n-1-i][j] = temp;
				}
			}
		} else if(num==2) {
			for(int i=0; i<m/2; i++) {
				for(int j=0; j<n; j++) {
					int temp = arr[j][i];
					arr[j][i] = arr[j][m-1-i];
					arr[j][m-1-i] = temp;
				}
			}
		} else if(num==3) {
			temp = new int[m][n];
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					temp[i][j] = arr[n-1-j][i];
				}
			}
			int cur = n;
			n = m;
			m = cur;
			arr = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = temp[i][j];
				}
			}
		} else if(num==4) {
			temp = new int[m][n];
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					temp[i][j] = arr[j][m-1-i];
				}
			}
			int cur = n;
			n = m;
			m = cur;
			arr = new int[n][m];
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = temp[i][j];
				}
			}
		} else if(num==5) {
			temp = new int[n/2][m/2];
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<m/2; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for(int i=n/2; i<n; i++) {
				for(int j=0; j<m/2; j++) {
					arr[i-n/2][j] = arr[i][j]; 
				}
			}
			for(int i=n/2; i<n; i++) {
				for(int j=m/2; j<m; j++) {
					arr[i][j-m/2] = arr[i][j];
				}
			}
			for(int i=0; i<n/2; i++) {
				for(int j=m/2; j<m; j++) {
					arr[n/2+i][j] = arr[i][j];
				}
			}
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<m/2; j++) {
					arr[i][m/2+j] = temp[i][j];
				}
			}
		} else if(num==6) {
			temp = new int[n/2][m/2];
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<m/2; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			for(int i=0; i<n/2; i++) {
				for(int j=m/2; j<m; j++) {
					arr[i][j-m/2] = arr[i][j];
				}
			}
			for(int i=n/2; i<n; i++) {
				for(int j=m/2; j<m; j++) {
					arr[i-n/2][j] = arr[i][j];
				}
			}
			for(int i=n/2; i<n; i++) {
				for(int j=0; j<m/2; j++) {
					arr[i][m/2+j] = arr[i][j];
				}
			}
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<m/2; j++) {
					arr[n/2+i][j] = temp[i][j];
				}
			}
		}
	}
}

