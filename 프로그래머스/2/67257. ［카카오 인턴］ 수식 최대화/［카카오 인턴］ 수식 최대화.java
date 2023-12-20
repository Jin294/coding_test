import java.util.*;

class Solution {
    static long max;
    static List<Long> expressionNums = new ArrayList<>();
    static List<Character> expressionOps = new ArrayList<>();
    static char[] ops = new char[]{'+', '-', '*'};
    static char[] priorities = new char[3];
    
    static boolean[] visited;
    
    public long solution(String expression) {
        max = 0;
        
        int idx = 0;
        // 순열만들 때 방문여부 저장하는 배열
        visited = new boolean[3];
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*')  {
                expressionOps.add(ch);
                // 연산자 전까지의 문자열을 숫자로 저장
                expressionNums.add(Long.parseLong(expression.substring(idx, i)));
                // 위치 재조정
                idx = i + 1;
            }
        }
        expressionNums.add(Long.parseLong(expression.substring(idx)));
        
        // 순열
        permutation(0);
                
        return max;
    }
    
    // 계산 : 이부분이 어려웠다.
    public long calcExpression() {
        // 계산과정을 저장할 리스트를 만듦 : 깊은복사
        List<Long> tmpExpressionNums = new ArrayList<>(expressionNums);
        List<Character> tmpExpressionOps = new ArrayList<>(expressionOps);
        
        // 주어진 문자열의 연산자를 모두 사용할 때 까지
        while (tmpExpressionOps.size() > 0) {
            int maxPriority = 0;
            for (int i = 0; i < tmpExpressionOps.size(); i++) {
                // maxPriority 값 경신
                // 현재 연산자의 우선순위를 가져온다.
                maxPriority = Math.max(getPriority(tmpExpressionOps.get(i)), maxPriority);
            }
            
            // 연산자 리스트를 돌면서
            for (int i = 0; i < tmpExpressionOps.size(); i++) {
                // 현재 연산자의 우선순위와 최고우선순위가 같다면
                if (getPriority(tmpExpressionOps.get(i)) == maxPriority) {
                    // 숫자 리스트의 i 위치에 더한다
                    // remove 메서드는 제거한 요소를 리턴한다.
                    // i 위치에서 숫자를 두 번 빼기 때문에 다시 i위치에 넣어주면 된다.
                    tmpExpressionNums.add(i,
                        calc(tmpExpressionNums.remove(i), tmpExpressionNums.remove(i),
                            tmpExpressionOps.remove(i)));
                    break;
                }
            }
        }
        
        return tmpExpressionNums.get(0);
    }
    
    private long calc(long num1, long num2, char op) {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
    
    // 연산자의 우선순위를 리턴하는 메서드
    public int getPriority(char op) {
        int priority;
        if (op == priorities[0]) { // 첫번째 우선순위라면 가장 큰 값 2
            priority = 2;
        } else if (op == priorities[1]) { // 그 다음순위는 1
            priority = 1;
        } else {
            priority = 0;
        }
        return priority;
    }
    
    // 순열
    public void permutation(int depth) {
        if (depth == 3) {
            max = Math.max(Math.abs(calcExpression()), max);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priorities[depth] = ops[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}