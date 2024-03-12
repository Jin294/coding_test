import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        makeWords(new StringBuilder(), 0);
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }
    
    public void makeWords(StringBuilder sb, int depth) {
        if (depth == 5) {
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            sb.append(vowels[i]);
            set.add(sb.toString());
            makeWords(sb, depth + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}