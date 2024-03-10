import java.util.*;

class Solution {
    HashMap<String, Set<String>> accused;
    public int[] solution(String[] id_list, String[] report, int k) {
        // 맵으로 아이디에 숫자 할당
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }
                
        // 이차원 부울배열로 신고여부 체크하기 => 나중에 메일받는거 체크
        // 누구로부터 신고받았는지 set으로 확인
        accused = new HashMap<>();
        boolean[][] matrix = new boolean[id_list.length][id_list.length];
        for (int i = 0; i < report.length; i++) {
            String[] tokens = report[i].split(" ");
            int accuse = map.get(tokens[0]);
            int target = map.get(tokens[1]);
            
            matrix[accuse][target] = true;
            if (!accused.containsKey(tokens[1])) {
                accused.put(tokens[1], new HashSet<>());
            }
            accused.get(tokens[1]).add(tokens[0]);
        }
        
        // 메일을 받는 횟수
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = count(matrix[i], id_list, k);
        }
        return answer;
    }
    
    // id가 몇 통의 메일을 받는지 그 개수를 세자
    public int count(boolean[] isChecked, String[] id_list, int limit) {
        int answer = 0;
        for (int i = 0; i < isChecked.length; i++) {
            if (isChecked[i]) {
                if (accused.get(id_list[i]).size() >= limit) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}