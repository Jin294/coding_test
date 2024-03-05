import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> answerList = new ArrayList<>();
    public String[] solution(String[] orders, int[] course) {
        // 1. order를 알파벳 오름차순으로 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] letter = orders[i].toCharArray();
            Arrays.sort(letter);
            orders[i] = String.valueOf(letter);
        }
        
        // 2. 각 order를 기준으로 courseLength만큼의 조합 만들기
        for (int courseLength : course) {
            for (String order : orders) {
                combination("", order, courseLength);
            }
            
            // 3. 가장 많은 조합을 answer에 저장한다.
            if (!map.isEmpty()) {
                List<Integer> countList = new ArrayList<>(map.values());
                // 가장 많이 주문한 조합의 빈도수
                int max = Collections.max(countList);
                
                if (max > 1) {
                    for (String key : map.keySet()) {
                        if (map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }
                map.clear();
            }
        }
        
        Collections.sort(answerList);
        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    
    public void combination(String order, String others, int count) {
        // 탈출조건
        if (count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        
        // 수행동작
        for (int i = 0; i < others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i + 1), count - 1);
        }
    }
}