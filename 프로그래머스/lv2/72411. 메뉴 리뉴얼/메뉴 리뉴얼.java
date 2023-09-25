import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
List<String> result = new ArrayList<>();

        // 메뉴 조합 생성
        for (String order : orders) {
            char[] orderChars = order.toCharArray();
            Arrays.sort(orderChars);
            int n = orderChars.length;
            for (int courseLength : course) {
                if (n >= courseLength) {
                    boolean[] isSelected = new boolean[n];
                    generateCombination(orderChars, isSelected, 0, 0, courseLength, new StringBuilder(), result);
                }
            }
        }

        // 길이 별로 정렬
        Map<Integer, List<String>> courseMenus = new HashMap<>();
        for (String menu : result) {
            int menuLength = menu.length();
            courseMenus.computeIfAbsent(menuLength, k -> new ArrayList<>()).add(menu);
        }

        // 빈도가 2 이상인 것만 추출
        Set<String> set = new HashSet<>();
        for (int courseLength : course) {
            if (courseMenus.containsKey(courseLength)) {
                List<String> menus = courseMenus.get(courseLength);
                int maxFrequency = 0;
                for (String menu : menus) {
                    maxFrequency = Math.max(maxFrequency, map.get(menu));
                }
                if (maxFrequency >= 2) {
                    for (String menu : menus) {
                        if (map.get(menu) == maxFrequency) {
                            set.add(menu);
                        }
                    }
                }
            }
        }

        List<String> answerList = new ArrayList<>(set);
        answerList.sort(String::compareTo);
        return answerList.toArray(new String[0]);
    }
    
        private void generateCombination(char[] orderChars, boolean[] isSelected, int start, int depth, int courseLength, StringBuilder sb, List<String> result) {
        if (depth == courseLength) {
            String menu = sb.toString();
            result.add(menu);
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i = start; i < orderChars.length; i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                sb.append(orderChars[i]);
                generateCombination(orderChars, isSelected, i + 1, depth + 1, courseLength, sb, result);
                sb.setLength(sb.length() - 1);
                isSelected[i] = false;
            }
        }
    }
}