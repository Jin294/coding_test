import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                list.add(i);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            int one = list.get(i);
            int two = yellow / one;

            if ((two + 2) * 2 + one * 2 == brown) {
                answer[0] = two + 2;
                answer[1] = one + 2;
                break;
            }
        }
        
        return answer;
    }
}