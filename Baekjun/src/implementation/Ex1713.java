package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex1713 {
	
	public static class Recom implements Comparable<Recom>{
		int num;
		int reNum;
		int date;
		
		public Recom(int num, int reNum, int date) {
			this.num = num;
			this.reNum = reNum;
			this.date = date;
		}

		public final int getNum() {
			return num;
		}

		public final int getReNum() {
			return reNum;
		}

		public final int getDate() {
			return date;
		}
		
		public int compareTo(Recom other) {
			if(this.reNum == other.reNum) {
				return other.date - this.date;
			}
			return this.reNum - other.reNum;
		}
	}
	public static int n, t;
	public static Recom[] rec;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		t = Integer.parseInt(br.readLine());
		rec = new Recom[1000];

		for(int i=0; i<1000; i++) {
			rec[i] = new Recom(i, 1001, 0);
		}
		
		int idx = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<t; i++) {
			
			int num = Integer.parseInt(st.nextToken());
			
			boolean check = false;
			
			if(rec[n-1].getReNum()==1001) {//���� n���� �ĺ���õ�� �ȵǾ��ٸ�
				for(int j=0; j<n; j++) {
					if(num==rec[j].getNum() && rec[j].getReNum()!=1001) {//�ĺ� ��ȣ�� ����, �̹� ��õ �޾Ҵ� ����̶��
						rec[j].reNum++;
						check = true;
						break;
					}
				}
				if(!check) {//���ο� �ĺ����
					rec[idx] = new Recom(num, 1, 0);
					idx++;
				}
			} else {//n���� �ĺ��� ��õ�Ǿ��ٸ�
				
				for(int j=0; j<n; j++) {
					if(num==rec[j].getNum()) {//���� �ĺ��� �ִٸ�
						rec[j].reNum++;
						check = true;
						break;
					}
				}
				if(!check) {//���� �ĺ��� ���ٸ� �� �տ� �ִ� �ĺ� ����
					rec[0] = new Recom(rec[0].getNum(), 1001, 0);
					rec[idx] = new Recom(num, 1, 0);
					idx++;
				}
			}
			Arrays.sort(rec);
//			System.out.println((i+1));
			dateUp();
//			print();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(rec[i].getReNum()!=1001) {
				list.add(rec[i].getNum());	
			}
		}
		Collections.sort(list);
		
		for(int v : list) {
			System.out.print(v + " ");
		}
	}
	
	public static void dateUp() {
		for(int i=0; i<n; i++) {
			if(rec[i].getReNum()!=1001) {
				rec[i].date++;
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<n; i++) {
			System.out.println((i+1) + "�� : " + rec[i].getNum() + " " + rec[i].getReNum() + " " + rec[i].getDate());
		}
		System.out.println();
	}
}
