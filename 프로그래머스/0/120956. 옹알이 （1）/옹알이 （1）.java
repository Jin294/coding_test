class Solution {
    String[] spells = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        // 1. 주어진 옹알이에 네 가지 발음이 포함되어 있는지 확인 후, 대체
        // 각 문자열에 발음은 최대 한 번만 들어있다.
        for (int i = 0; i < babbling.length; i++) {
            for (String spell : spells) {
                babbling[i] = babbling[i].replace(spell, "1");
            }
            babbling[i] = babbling[i].replace("1", "");
            
            // 2. 옹알이 단어가 비어있다면 카운트
            if (babbling[i].isEmpty()) answer++;
        }

        return answer;
    }
}