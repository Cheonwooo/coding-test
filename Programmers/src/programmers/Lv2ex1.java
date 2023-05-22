package programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Lv2ex1 {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] arr = {{"15:00", "17:00"},
				{"16:40", "18:20"},
				{"14:20", "15:20"},
				{"14:10", "19:20"},
				{"18:20", "21:20"},
				{"14:20", "16:40"},
				{"17:20", "19:40"},
				{"16:40", "18:10"}};
				
		
		System.out.println(solution(arr));
	}
	
	public static int solution(String[][] book_time) {
        int answer = 0;
        int[][] re_book_time = new int[book_time.length][2];
        int[][] book_time_hour = new int[book_time.length][2];
        int[][] book_time_min = new int[book_time.length][2];
        boolean[] check = new boolean[book_time.length];//default : false

        for(int i=0; i<book_time.length; i++) {
            book_time[i][0] = book_time[i][0].replace("\"", "").replace(":", "");
            book_time[i][1] = book_time[i][1].replace("\"", "").replace(":", "");
            
            book_time_hour[i][0] = Integer.parseInt(book_time[i][0].substring(0,2))*60;
            book_time_hour[i][1] = Integer.parseInt(book_time[i][1].substring(0,2))*60;
            
            book_time_min[i][0] = Integer.parseInt(book_time[i][0].substring(2));
            book_time_min[i][1] = Integer.parseInt(book_time[i][1].substring(2));

            re_book_time[i][0] = book_time_hour[i][0] + book_time_min[i][0];
            re_book_time[i][1] = book_time_hour[i][1] + book_time_min[i][1];
            
            
        }

        Arrays.sort(re_book_time, (a, b) -> a[0] - b[0]);

        int time = 0;
        for(int i=0; i<re_book_time.length; i++) {
            if(!check[i]) {//사용되지 않은 시간은 false
                check[i] = true;
                time = re_book_time[i][1];
                answer++;
            } else continue;

            for(int j=0; j<re_book_time.length; j++) {
                if(re_book_time[j][0]-time >= 0 && !check[j]) { //가장 빠른 다음 시간
                    check[j] = true;
                    time = re_book_time[j][1];

                }
            }

        }

        return answer;
    }
	
	/*public static int solution(String[][] book_time) {//시간대별로 정렬
		
		int[][] re_book_time = new int[book_time.length][2];
		String[][] arr = new String[book_time.length][2];
		int[] rooms = new int[1450];
		
		for(String[] time : book_time) {
			String join = time[0];
			String out = time[1];
			
			rooms[trans(join)]++;
			rooms[trans(out)+10]--;
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<rooms.length; i++) {
			rooms[i] += rooms[i-1];
			max = Math.max(max, rooms[i]);
		}
		
		return max;
	}
	
	public static int trans(String str) {
		
		String[] arr = str.split(":");
		int hour = Integer.parseInt(arr[0])*60;
		int minute = Integer.parseInt(arr[1]);
		
		return hour+minute; 
		
	}*/
	
	

}
