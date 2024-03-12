import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    int[] nums = {0, 4, (int)('I' - 'A'), (int)('O' - 'A'), (int)('U' - 'A')};
    public int solution(String word) {
        makeWords(new StringBuilder(), 0);
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.indexOf(word);
    }
    
    public void makeWords(StringBuilder sb, int depth) {
        set.add(sb.toString());
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            sb.append((char)('A' + nums[i]));
            makeWords(sb, depth + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}