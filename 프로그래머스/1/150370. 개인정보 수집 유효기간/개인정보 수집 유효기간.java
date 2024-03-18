import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String term: terms) {
            String[] record = term.split(" ");
            map.put(record[0].charAt(0), Integer.parseInt(record[1]));
        }
        
        int td = getDays(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] li = privacies[i].split(" ");
            
            String nowDate = li[0];
            char nowKind = li[1].charAt(0);
            
            int now = getDays(li[0]) + map.get(li[1].charAt(0)) * 28;
            
            if (td >= now) {
                list.add(i + 1);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public int getDays(String date) {
        String[] dateSplited = date.split("\\.");
        int y = Integer.parseInt(dateSplited[0]);
        int m = Integer.parseInt(dateSplited[1]);
        int d = Integer.parseInt(dateSplited[2]);
        return y * 12 * 28 + m * 28 + d;
    }
}