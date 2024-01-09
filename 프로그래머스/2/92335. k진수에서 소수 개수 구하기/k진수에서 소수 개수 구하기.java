import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // 1. n을 k진수로 바꾼다.
        // 2. 1을 문자열로 변환
        // 3. 2를 0 기준 split한다
        // 필터링하는 이유는 테케 2처럼 0이 2개 이상인 경우
        // 빈 문자열이 들어가는 것을 걸러내기 위해서
        String[] numStr = Integer.toString(n, k).split("0");
        String[] filteredParts = Arrays.stream(numStr).filter(s -> s.length() != 0).toArray(String[]::new);
        long[] nums = new long[filteredParts.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Long.parseLong(filteredParts[i]);
        }
        
        // 4. 3의 숫자들이 소수인지 체크
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        } else if (num == 2) {
            return true;
        }
        
        long limit = (long) Math.sqrt(num);
        for (long i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}