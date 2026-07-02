import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        Queue<Integer> que = new LinkedList();
        if (s == null && s.length() < 0){ return false;}
       if (s.startsWith(")") || s.endsWith("(")) {
   return false;
}
      s.chars().forEach(c -> {
    if (c == '(') {
        que.add(1);
    } else if (c == ')') {
        que.add(-1);
    }
});
        int cnt = 0;
        while(!que.isEmpty()){
            cnt += que.poll();
            if(cnt <= -1) {return false;}
            
        }
        
        

        return cnt == 0? true:false;
    }
}