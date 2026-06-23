import java.util.stream.*;
class Solution {
    public int solution(int hp) {
        return IntStream.of(hp) 
            .map(t -> {
                int chp = t;
                int count = 0;
                
                count += chp / 5;
                chp %= 5;
              
                count += chp / 3;
                chp %= 3;
          
                count += chp / 1;
                chp %= 1;
                
                return count;
            })
            .findFirst()
            .orElse(0);
    }
}