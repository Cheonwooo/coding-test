package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Ex20055 {
	
	public static class Belt{
		int x;
		int y;
		int dura;
		boolean robot;
		boolean off;
		
		public Belt(int x, int y, int dura, boolean robot, boolean off) {
			this.x = x;
			this.y = y;
			this.dura = dura;
			this.robot = robot;
			this.off = off;
		}

		public final int getX() {
			return x;
		}

		public final int getY() {
			return y;
		}

		public final int getDura() {
			return dura;
		}

		public final boolean isRobot() {
			return robot;
		}

		public final boolean isOff() {
			return off;
		}

		public final void setRobot(boolean robot) {
			this.robot = robot;
		}
		
		
		
	}
	
	public static int over;
	public static Belt[][] belt;
	public static int n, k;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		belt = new Belt[2][n];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			belt[0][i] = new Belt(0, i, Integer.parseInt(st.nextToken()), false, false);
		}
		for(int i=n-1; i>=0; i--) {
			belt[1][i] = new Belt(0, i, Integer.parseInt(st.nextToken()), false, false);
		}
		
		over = 0;
		int answer = 0;
		while(true) {
			answer++;
			beltMove();
			robotMove();			
			robotOn();
			check();
//			System.out.println(over);
			if(over>=k) break;
		}
		
		System.out.println(answer);
	}
	
	public static void beltMove() {
		Belt temp = new Belt(belt[1][0].getX(), belt[1][0].getY(), belt[1][0].getDura(), belt[1][0].isRobot(), belt[1][0].isOff());
		
		int idx = 0;
		for(int i=1; i>=0 ;i--) {
			
			if(i==1) {
				while(true) {
					belt[i][idx].x = belt[i][idx+1].getX();
					belt[i][idx].y = belt[i][idx+1].getY();
					belt[i][idx].dura = belt[i][idx+1].getDura();
					belt[i][idx].robot = belt[i][idx+1].isRobot();
					belt[i][idx].off = belt[i][idx+1].isOff();
					
					idx++;
					
					if(idx==n-1) {
						belt[i][idx].x = belt[i-1][idx].getX();
						belt[i][idx].y = belt[i-1][idx].getY();
						belt[i][idx].dura = belt[i-1][idx].getDura();
						belt[i][idx].robot = belt[i-1][idx].isRobot();
						belt[i][idx].off = belt[i-1][idx].isOff();
						
						break;
					}
				}
			} else {
				while(true) {
					belt[i][idx].x = belt[i][idx-1].getX();
					belt[i][idx].y = belt[i][idx-1].getY();
					belt[i][idx].dura = belt[i][idx-1].getDura();
					belt[i][idx].robot = belt[i][idx-1].isRobot();
					belt[i][idx].off = belt[i][idx-1].isOff();
					
					idx--;
					
					if(idx==0) {
						belt[i][idx].x = temp.getX();
						belt[i][idx].y = temp.getY();
						belt[i][idx].dura = temp.getDura();
						belt[i][idx].robot = temp.isRobot();
						belt[i][idx].off = temp.isOff();
						
						break;
					}
				}
			}
		}
		belt[0][n-1].robot = false;
	}
	
	public static void robotMove() {
		for(int i=n-2; i>=0; i--) {
			if(belt[0][i].isRobot() && !belt[0][i+1].isRobot() && belt[0][i+1].getDura()>=1) {//로봇이 있다면
				if(i==n-2) {//내리는 위치로 이동하면 바로 로봇 내림
					belt[0][i].robot = false;
					belt[0][i+1].dura-=1;
				} else {
					belt[0][i].robot = false;
					belt[0][i+1].dura-=1;
					belt[0][i+1].robot = true;
				}
			}
		}
	}
	
	public static void robotOn() {
		if(belt[0][0].getDura()!=0) {//첫번째 칸에 로봇이 없다면
			belt[0][0].dura-=1;
			belt[0][0].robot = true;;
		}
	}

	public static void check() {
		for(int i=0; i<n; i++) {
			if(belt[0][i].getDura()==0 && !belt[0][i].isOff()) {
				belt[0][i].off = true;
				over++;
			}
		}
		for(int i=n-1; i>=0; i--) {
			if(belt[1][i].getDura()==0 && !belt[1][i].isOff()) {
				belt[1][i].off = true;
				over++;
			}
		}
	}
}
