import java.util.*;

class Solution {
    Map<Character, Integer> map = new HashMap<>();
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < choices.length; i++) {
            int[] score = choose(choices[i]);
            
            char key = survey[i].charAt(score[0]);
            if (map.containsKey(key)) {
                map.put(key, map.getOrDefault(key, 0) + score[1]);
            } else {
                map.put(key, score[1]);
            }
        }
        
        answer.append(getBigger('R', 'T'));
        answer.append(getBigger('C', 'F'));
        answer.append(getBigger('J', 'M'));
        answer.append(getBigger('A', 'N'));
        
        return answer.toString();
    }
    
    public int[] choose(int choice) {
        return new int[]{choice <= 4 ? 0 : 1, Math.abs(choice - 4)};
    }
    
    public Character getBigger(char first, char second) {
        int one = map.getOrDefault(first, 0);
        int two = map.getOrDefault(second, 0);
        
        if (one == two) {
            return first;
        }
        
        return one < two ? second : first;
    }
}