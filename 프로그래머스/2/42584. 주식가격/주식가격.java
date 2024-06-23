class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            int idx = i;
            for (int j = i + 1; j < len; j++) {
                idx++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            answer[i] = idx - i;
        }
        return answer;
    }
}