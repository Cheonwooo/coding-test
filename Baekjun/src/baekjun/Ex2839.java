package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2839 {

	public static void main(String[] args) throws IOException{
		/*//5로 나눈 후
		//주어진 수가 5로 나누어질 경우 -> 결과 출력
		//1. 나머지가 3으로 나누어 지는 경우 -> 결과 출력
		//1-1. 3으로 나누고 난 후 나머지가 3으로 나누어 지지 않는경우
		//1-1-1. 주어진 수가 3의 배수 인지 확인 -> 결과 출력 
		//1-1-2. 주어진 수가 3의 배수도 아니라면 -> -1출력
		//3으로 나눈 후(5보다 작은 수일 경우)
		//2. 주어진 수가 3으로 나누어질 경우 -> 결과 출력
		//3. 주어진 수가 3으로 나누어 지지 않는 경우 -> -1출력
		//4. 3으로 나누고 난 후 나머지가 3으로 나누어 지지 않는 경우 -> -1 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		
		if(num >= 5) { //num이 5보다 클 경우
			if(num%5==0) { //5로 나누어질 경우
				sum = num/5;
				System.out.println(sum);
			} else if(num%5!=0){ //5로 나눈 후 나머지가 있을경우
				sum = num/5;
				if((num%5)%3==0) { //5로 나눈 후 나머지가 3으로 나누어지는 경우
					sum += (num%5)/3;
					System.out.println(sum);
				} else { //5로 나눈 후 나머지가 3으로 나누어지지 않는 경우
					if(num%3==0) { //주어진 수가 3의 배수인 경우
						sum = num/3;
						System.out.println(sum);
					} else { 
						if(num%3!=0) { //주어진 수가 3의 배수도 아니라면
							for(int i=1; i<5; i++) {
								if((num-(3*i))>0 && (num-(3*i))%5==0) {
									sum = i + ((num-(3*i))/5);
									break;
								} else {
									sum = -1;
								}
							}
						}
						System.out.println(sum);
					}
				}
			}
		}
		 else { //num이 5보다 작을 경우
			if(num%3==0) { //3의 배수일 경우
				sum = num/3;
				System.out.println(sum);
			} else { //3의 배수가 아닐 경우
				System.out.println(-1);
			}
		}*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		if(num == 4 || num == 7 ) {
			System.out.println(-1);
		} else if(num%5==0) {
			System.out.println(num/5);
		} else if(num%5==1 || num%5==3) {
			System.out.println((num/5) + 1);
		} else if(num%5==2 || num%5==4) {
			System.out.println((num/5) + 2);
		}
	}
}
