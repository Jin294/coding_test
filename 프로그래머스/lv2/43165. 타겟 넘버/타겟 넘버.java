class Solution {
    static int answer = 0;
    static int t;
    public int solution(int[] numbers, int target) {
        t = target;
        recursion(numbers, 0, 0);
        return answer;
    }
    
    public void recursion(int[] numbers, int depth, int sum) {
        if (depth == numbers.length) {
            if (sum == t) {
                answer++;   
            }
            return;
        }
        
        recursion(numbers, depth + 1, sum + numbers[depth]);
        recursion(numbers, depth + 1, sum - numbers[depth]);
    }
}