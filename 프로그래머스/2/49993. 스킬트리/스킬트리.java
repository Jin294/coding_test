import java.util.*;

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public int solution(String skill, String[] skill_trees) {
        for (int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        
        int answer = 0;
        for (String target : skill_trees) {
            if (isSkillCanLearn(target.toCharArray())) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isSkillCanLearn(char[] arr) {
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            // 키가 아예 없으면 패스
            if (!map.containsKey(arr[i])) {
                continue;
            }

            // 키가 들어있는데 idx와 일치하지 않으면 안됨
            if (map.get(arr[i]) != idx) {
                return false;
            } else {
                idx++;
            }
        }
        
        return true;
    }
}