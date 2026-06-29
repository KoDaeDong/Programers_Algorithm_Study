import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] citations) {
        
    TreeSet<Integer> set = Arrays.stream(citations).boxed()
        .collect(Collectors.toCollection(TreeSet::new));
        
        
		int[] count = new int[set.last() + 1];
		for (int c : citations) count[c]++;

		int totalPaper = 0;
        
		for (int h = set.last(); h >= 0; h--) {
			totalPaper += count[h];
			if (totalPaper >= h) {
				
				return h;
			}

		}
        return 0;
    }
}