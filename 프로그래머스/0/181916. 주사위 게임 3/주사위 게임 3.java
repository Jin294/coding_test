import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = {a, b, c, d};
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 키 하나 => 하나 있는 키 가져오자
        if (map.size() == 1) {
            for (int key : map.keySet()) {
                answer += key * 1111;
            }
            return answer;
        }
        
        // 키 4개
        if (map.size() == 4) {
            answer = 6;
            for (int key : map.keySet()) {
                answer = Math.min(answer, key);
            }
            
            return answer;
        }
        
        // 키 3개
        if (map.size() == 3) {
            // 키 하나만 있는거 담자
            answer = 1;
            
            for (int key : map.keySet()) {
                if (map.get(key) == 1) {
                    answer *= key;
                }
            }
            
            return answer;
        }
        
        // 키 2개
        // 3, 1 조합
        if (map.containsValue(3)) {
            for (int key : map.keySet()) {
                if (map.get(key) == 3) {
                    answer += 10 * key;
                } else {
                    answer += key;
                }
            }
            
            return answer * answer;
        }
        
        // 2, 2 조합
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(key);
        }
        
        int one = list.get(0);
        int two = list.get(1);
        
        return (one + two) * Math.abs(one - two);
    }
}