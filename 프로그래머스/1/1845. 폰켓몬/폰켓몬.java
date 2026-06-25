import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> poke = new HashSet();
        
        for(int x : nums){
            poke.add(x);
        }
        
        if(nums.length / 2 > poke.size() ){
            return poke.size();
        }
        if( nums.length / 2 < poke.size()){
            return nums.length / 2;
        }
        return nums.length / 2;
    }
}