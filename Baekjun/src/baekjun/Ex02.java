package baekjun;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		int duringtime = sc.nextInt();
		int sumtime = m+duringtime;
		int abstime = sumtime%60; // 분+걸리는 시간을 60으로 나눈 나머지
		int divtime = sumtime/60; // 분+걸리는 시간을 60으로 나눈 몫
		
		if(sumtime<60) {
			System.out.println(h + " " + sumtime);
		} else if(sumtime>=60 && sumtime%60==0) { //걸리는 시간 + 분이 60배수일 경우
			if(h+divtime>=24) {//h=22, divtime=5 sum=27-24
				System.out.println(h+divtime-24 + " " + "0");
			} else {
				System.out.println(h+divtime + " " + "0");
			}
		} else if(sumtime%60!=0) { //걸리는 시간 + 분이 60배수가 아닐경우
			if(h+divtime>=24) {
				System.out.println(h+divtime-24 + " " + abstime);
			} else {
				System.out.println(h+divtime + " " + abstime);
			}
		}
	}
}
