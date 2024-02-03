import java.util.*;

class Solution {
    // 매개변수 전역화
    String[] userIds;
    String[] bannedIds;
    
    // 모든 경우의 제재 아이디 목록을 담을 result
    HashSet<HashSet<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        // 전역변수에 매개변수 할당
        userIds = user_id;
        bannedIds = banned_id;
        
        // 초기화
        result = new HashSet<>();

        // 깊이우선탐색 시작
        DFS(new HashSet<>(), 0);
        
        return result.size();
    }
    
    // set : 가려진 제재 아이디와 매칭될 수 있는 아이디들
    // depth : 제재 아이디 목록의 인덱스
    public void DFS(HashSet<String> idList, int depth) {
        // 모든 제재 아이디를 탐색했다면, 목록을 result에 넣고 중단
        if (depth == bannedIds.length) {
            result.add(idList);
            return;
        }
        
        // 모든 이벤트 응모자 아이디를 탐색
        for (int i = 0; i < userIds.length; i++) {
            // 현재 아이디가 이미 매칭가능판정을 받고 set에 들어있다면 패스
            if (idList.contains(userIds[i])) {
                continue;
            }
            
            // 현재 아이디와 현재 제재 아이디를 검사해 매칭된다면
            if (checkIsMatched(userIds[i], bannedIds[depth])) {
                idList.add(userIds[i]);
                // depth를 증가시켜 다음 제재 아이디와도 검사하는 한편
                // 새로운 set으로 시작해야함
                // 참조값(위치값) 때문에 새로 만들지 않으면 이전단계 set에 데이터가 들어간다
                DFS(new HashSet<>(idList), depth + 1);
                idList.remove(userIds[i]);
            }
        }
    }
    
    // 두 아이디가 매칭될 수 있는지 검사
    public boolean checkIsMatched(String userId, String bannedId) {
        // 길이가 같은지 1차 검사
        if (userId.length() != bannedId.length()) {
            return false;
        }
        
        for (int i = 0; i < userId.length(); i++) {
            // *로 가려진 부분이 아닌데 i번째 글자가 같지 않다면 바로 중단
            if (bannedId.charAt(i) != '*' && userId.charAt(i) != bannedId.charAt(i)) {
                return false;
            }
        }
        
        // 끝까지 살아남았다면 매칭이 가능하다는 것
        return true;
    }
}