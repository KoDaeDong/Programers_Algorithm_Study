/*
 ! 예외처리 <모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return.>


*/
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> h = 
            new PriorityQueue<>();
        
        int x, y;
for (int s : scoville) {
    h.add(s);
}
        
        int cnt = 0;
        while(h.peek() < K){
         
            if(h.size() < 2) return -1;
           
            x = h.poll();
            y = h.poll();
            
            h.add((y*2) + x);
             cnt ++;
        }
        return cnt;
    }
}