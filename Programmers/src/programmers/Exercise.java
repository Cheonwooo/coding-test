package programmers;

import java.util.*;


class Exercise {
    public int solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        //0 01 02 03 04 05 06 07 08
        //0 09 10 11 12 13 14 15 16
        
        Arrays.sort(citations);
        
        int lo = 0;
        int hi = citations.length;
        int idx = citations.length/2;
        
        while(true){
            if(citations[idx] > citations.length-idx+1){//인덱스 좌로 이동
                hi = idx;
                idx = hi/2;
            } else if(citations[idx] < citations.length-idx+1){ //인덱스 우로 이동, 저장
                list.add(citations[idx]);
                lo = idx;
                idx = (lo + hi)/2;
            } else {//같을 경우
                list.add(citations[idx]);
                break;
            }
            
        }
        Collections.sort(list, Collections.reverseOrder());
        answer = list.get(0);
        
        return answer;
}
}