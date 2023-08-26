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
			
			if(rec[n-1].getReNum()==1001) {//아직 n명의 후보추천이 안되었다면
				for(int j=0; j<n; j++) {
					if(num==rec[j].getNum() && rec[j].getReNum()!=1001) {//후보 번호가 같고, 이미 추천 받았던 사람이라면
						rec[j].reNum++;
						check = true;
						break;
					}
				}
				if(!check) {//새로운 후보라면
					rec[idx] = new Recom(num, 1, 0);
					idx++;
				}
			} else {//n명의 후보가 추천되었다면
				
				for(int j=0; j<n; j++) {
					if(num==rec[j].getNum()) {//같은 후보가 있다면
						rec[j].reNum++;
						check = true;
						break;
					}
				}
				if(!check) {//같은 후보가 없다면 맨 앞에 있는 후보 삭제
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
			System.out.println((i+1) + "번 : " + rec[i].getNum() + " " + rec[i].getReNum() + " " + rec[i].getDate());
		}
		System.out.println();
	}
}
