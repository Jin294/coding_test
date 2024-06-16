class Solution {
    String[] spells = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        // 1. 주어진 옹알이에 네 가지 발음이 포함되어 있는지 확인 후, 대체
        for (int i = 0; i < babbling.length; i++) {
            for (String spell : spells) {
                babbling[i] = babbling[i].replaceAll(spell, "1");
            }
        }

        // 2. 옹알이 단어가 순수 알파벳으로 이루어져 있다면 ok
        int answer = 0;
        for (String b : babbling) {
            if (isAllAlphabethic(b)) answer++;
        }

        return answer;
    }
    
    public boolean isAllAlphabethic(String str) {
        for (char x : str.toCharArray()) {
            if (!Character.isDigit(x)) return false;
        }
        
        return true;
    }
}