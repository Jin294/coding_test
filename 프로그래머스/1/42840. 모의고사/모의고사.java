import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(1, 2, 3, 4, 5));
        map.put(2, Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        map.put(3, Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        
        // 점수 계산
        int[] count = new int[4];
        for (int i = 1; i <= 3; i++) {
            List<Integer> picked = map.get(i);
            int size = picked.size();
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == picked.get(j % size)) count[i]++;
            }
        }
        
        // 최댓값 계산
        int max = Arrays.stream(count).max().getAsInt();
        
        // 최댓값과 일치하면 담고 오름차순 정렬
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if (count[i] == max) list.add(i);
        }
        Collections.sort(list);
        
        // 리스트를 배열로 옮기자
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}