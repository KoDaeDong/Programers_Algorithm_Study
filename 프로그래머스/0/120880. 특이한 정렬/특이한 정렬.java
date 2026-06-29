

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    
    public static int getDist(int val, int target) {
	    int diff = val - target;
	    int mask = diff >> 31;
	    return (diff ^ mask) - mask;
	}
    
    public int[] solution(int[] numlist, int n) {
             ArrayList<Integer> nums = Arrays.stream(numlist).boxed().collect(Collectors.toCollection(ArrayList::new));
        
       nums.sort(Comparator
        	    .comparingInt((Integer ns) -> getDist(ns, n)) 
        	    .thenComparing(Collections.reverseOrder()));    
        
       int[] answer = nums.stream().mapToInt(i -> i).toArray();
           return answer;
    
    }
}