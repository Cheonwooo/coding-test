package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex16235 {
	
	public static int n, k, m;
	public static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
	public static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
	public static int[][] food, tempFood, A;
	public static int[][][] tree, tempTree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		food = new int[n+1][n+1];
		
		A = new int[n+1][n+1];
		tree = new int[n+1][n+1][8001];
		tempTree = new int[n+1][n+1][8001];
		
		
		for(int i=1; i<n+1; i++) {
			Arrays.fill(food[i], 5);//�ʱ� ��а� ä���	
			for(int j=1; j<n+1; j++) {
				Arrays.fill(tree[i][j], 8002);//�ʱ� ������ ���� ä���
				Arrays.fill(tempTree[i][j], 8002);
			}
		}
		
		for(int i=1; i<n+1; i++) {//�ܿ︶�� �߰��� ���
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<n+1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<m; i++) {//�ʱ� ���� ��ġ�� ����
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age =Integer.parseInt(st.nextToken());
			
			tree[x][y][0] = age;
			tempTree[x][y][0] = age;
		}
		
		while(k!=0) {
			k--;
			tempFood = new int[n+1][n+1];
			
			spring();
			summer();
			autumn();
			winter();
			copy();
		}
		
//		for(int i=1; i<n+1; i++) {
//			for(int j=1; j<n+1; j++) {
//				Arrays.sort(tree[i][j]);
//				if(tree[i][j][0]==8002) {
//					System.out.print(0 + " ");
//					continue;
//				}
//				for(int k=0; k<8001; k++) {
//					if(tree[i][j][k]!=8002)System.out.print(tree[i][j][k]+"/");
//					
//				}
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		for(int i=1; i<n+1; i++) {
//			for(int j=1; j<n+1; j++) {
//				System.out.print(food[i][j]+ " " );
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		int cnt = 0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				Arrays.sort(tree[i][j]);
				for(int k=0; k<8001; k++) {
					if(tree[i][j][k]==8002) break;
					else cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void spring() {//�������� ��� �԰�, ���� ������ �������
		//�������� ���� -> ���� � �������� ��� ����
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				Arrays.sort(tree[i][j]);
				Arrays.sort(tempTree[i][j]);
				for(int k=0; k<8001; k++) {
					if(tree[i][j][k]==8002) break;//8002�� ������ ���� �� �ڿ� ��� �迭�� ���� 8002
					if(tree[i][j][k] != 8002 && tree[i][j][k] <= food[i][j]) {//����� �ش� ������ ���̺��� ���ٸ�
						tempTree[i][j][k]++;
//						System.out.println(tempTree[i][j][k]);
//						System.out.println(tree[i][j][k] + " " + food[i][j]);
						food[i][j] -= tree[i][j][k];
					} else if(tree[i][j][k] != 8002 && tree[i][j][k] > food[i][j]) {//����� �����ϴٸ�
//						System.out.println("D: " +tree[i][j][k] + " " + food[i][j]);
						tempTree[i][j][k] = 8002;
						tempFood[i][j] += tree[i][j][k]/2;
					}
				}
			}
		}
	}
	
	public static void summer() {
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				food[i][j] += tempFood[i][j];
			}
		}
	}
	
	public static void autumn() {
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				Arrays.sort(tempTree[i][j]);
				for(int k=0; k<8001; k++) {
					
					if(tempTree[i][j][k] !=0 && tempTree[i][j][k]%5 == 0) {
						for(int p=0; p<8; p++) {
							int nx = i + dx[p];
							int ny = j + dy[p];
							
							if(nx<1 || nx>n || ny<1 || ny>n) continue;
							
							addTree(nx, ny);
						}
					}
				}
			}
		}
	}
	
	public static void winter() {//��� �߰�
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				food[i][j] += A[i][j];
			}
		}
	}
	
	public static void addTree(int x, int y) {
		for(int i=0; i<8001; i++) {
			if(tempTree[x][y][i]==8002) {//ó������ ������ 8002���� 1�� �ٲ�
				tempTree[x][y][i] = 1;
				break;
			}
		}
	}
	
	public static void copy() {//temp�� 
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				tree[i][j] = tempTree[i][j].clone();
			}
		}
	}
}
