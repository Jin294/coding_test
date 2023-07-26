import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            String item = clothes[i][0];
            
            if (!map.containsKey(kind)) {
                map.put(kind, new ArrayList<>());
            }
            map.get(kind).add(item);
        }
                
        int answer = 1;
        for (String kind : map.keySet()) {
            ArrayList<String> target = map.get(kind);
            answer *= (target.size() + 1);
        }
        
        return answer - 1;
    }
}