import java.util.*;

class Solution {
    Map<String, Integer> rank = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        // 별도의 배열 생성 없이 player로 반환할 예정
        for (int i = 0; i < players.length; i++) {
            rank.put(players[i], i);
        }
        
        for (String call : callings) {
            swapPlayers(players, call);
        }
        
        return players;
    }
    
    // 두 선수의 순서를 바꾼다
    public void swapPlayers(String[] players, String calledPlayer) {
        int calledRank = rank.get(calledPlayer);
        
        if (calledRank != 0) {
            // frontRank : 이름이 불린 선수의 바로 앞선수
            int frontRank = calledRank - 1;
            String tmp = new String(players[frontRank]);
            
            // 두 선수의 등수를 조정한다.
            rank.put(players[calledRank], calledRank - 1);
            rank.put(players[frontRank], calledRank);
            
            // 두 선수의 위치를 바꾼다.
            players[frontRank] = players[calledRank];
            players[calledRank] = tmp;
        }
    }
}