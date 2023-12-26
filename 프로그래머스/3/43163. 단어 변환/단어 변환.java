import java.util.*;

// 단어 하나하나마다 일일이 charAt으로 글자 비교하는 방법밖에 없나?
// 이외에는 방법이 생각나지 않는다.
// 최악의 경우에는 길이 10의 단어를 50을 거쳐야 하는데
// 500 + 490 + 480 + ...
// (500 + 501) / 2 = ((n * m) + (n * m + 1)) / 2 => n * m
// 단어길이 n, 단어개수 m;

// 일단 최종 변환이 가능한지부터 체크하고
// 가능하다면 일일이 단어변환

// gpt는 bfs 써보라고 함
// 이차원 리스트로 각 문자열의 인덱스에 들어갈 수 있는 알파벳을 수집
// bfs로 한글자씩 바꾼다음 set add에서 true 나오면 그 때에 큐에 넣는다?


class Solution {
    static Set<String> set = new HashSet<>();
    public int solution(String begin, String target, String[] words) {
        // target이 없다면 바로 0 반환
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        if (!dict.contains(target)) {
            return 0;
        }
                
        // BFS 구현
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            // 그냥 BFS로 구현하면 단어 하나마다 단계가 늘어난다
            // => 단계측정 어려움
            // 단계 측정을 위해 while문 안에 추가적인 반복문 구현
            for (int i = 0; i < size; i++) {
                String currentWord = q.poll();
                
                // 현재 단어가 목표에 도달하면 중단
                if (currentWord.equals(target)) {
                    return level;
                }
            
                // 문자 배열로 만든다
                char[] currentChars = currentWord.toCharArray();
                // 한 글자 씩 바꾼다
                for (int j = 0; j < currentChars.length; j++) {
                    char originalChar = currentChars[j];
                    
                    // a부터 z까지 모두 바꿔본다
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentChars[j] = c;
                        String newWord = new String(currentChars);
                        if (dict.contains(newWord)) {
                            q.add(newWord);
                            dict.remove(newWord);
                        }
                        currentChars[j] = originalChar;
                    }
                }
            }
            
            // 한 단계가 끝나면 단계 증가
            level++;
        }
        
        return 0;
    }
}