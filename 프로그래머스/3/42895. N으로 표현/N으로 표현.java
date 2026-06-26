import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int N, int number) {
        // dp[i]는 N을 i번 사용해서 만들 수 있는 수들의 집합
        // 배열 인덱스는 1부터 8까지 사용하므로 크기를 9로 설정
        Set<Integer>[] dp = new HashSet[9];

        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
            
            // 1. 단순히 N을 이어 붙인 경우 (예: 5, 55, 555)
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            // 2. 사칙연산 조합
            // j번 사용한 수와 i-j번 사용한 수들을 연산
            for (int j = 1; j < i; j++) {
                for (int op1 : dp[j]) {
                    for (int op2 : dp[i - j]) {
                        dp[i].add(op1 + op2);
                        dp[i].add(op1 - op2);
                        dp[i].add(op1 * op2);
                        if (op2 != 0) {
                            dp[i].add(op1 / op2); // 정수 나눗셈
                        }
                    }
                }
            }
            
            // 3. 목표 숫자 발견 시 즉시 반환
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        // 8번 넘게 사용해도 찾을 수 없는 경우
        return -1;
    }
}