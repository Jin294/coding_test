import java.util.*;

// words에 target이 있는지 먼저 검사한다
// 큐에 단어를 넣고 하나씩 뽑는다
// 뽑는 단어의 모든 글자마다 a - z로 변경해가며 words에 있는지 찾는다

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Set<String> set = new HashSet<>();
        for (String x : words) {
            set.add(x);
        }
        
        if (!set.contains(target)) {  // 타겟 없으면 종료
            return answer;
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int a = 0; a < size; a++) {
                String str = q.poll();
                
                if (str.equals(target)){
                    return answer;
                }
                
                char[] arr = str.toCharArray();
                for (int i = 0; i < str.length(); i++) {

                    char original = arr[i];
                    for (char x = 'a'; x <= 'z'; x++) {
                        arr[i] = x;
                        String replaced = new String(arr);
                        if (set.contains(replaced)) {
                            q.add(replaced);
                            set.remove(replaced);
                        }
                    }

                    arr[i] = original;
                }
            }
            
            // 한 단어에서 파생된 단어들이 모두 추가되면 그 때 레벨이 올라감
            answer++;
        }
        
        return 0;
    }
}