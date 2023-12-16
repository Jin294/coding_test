// 현재 보여지는 것으로 봐서는
// 배열의 길이 순으로 오름차순 정렬 후
// 거기서 원소 하나씩 뽑아내는 식으로
// 문제는 주어지는 데이터가 스트링으로 한꺼번에 제공되는것
// 일단 맨 처음에 앞뒤부터 두개씩 잘라내고
// 닫는 중괄호를 기점으로 스플릿하자

import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2);
        String[] splits = s.split("\\},\\{");
        Arrays.sort(splits, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        ArrayList<Integer> list = new ArrayList<>();
        for (String x : splits) {
            String[] arr = x.split(",");
            
            for (String item : arr) {
                int num = Integer.parseInt(item);
                if (!list.contains(num))  {
                    list.add(num);
                }
            }
        }
        
        
        Integer[] integerArray = list.toArray(new Integer[0]);
        int[] answer = new int[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            answer[i] = integerArray[i];
        }
        
        return answer;
    }
}