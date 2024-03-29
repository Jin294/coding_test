import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            int pick = pickDoll(board, move - 1);

            if (pick != 0) {
                if (!basket.isEmpty() && basket.peek() == pick) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.add(pick);
                }
            }
        }
        
        return answer;
    }
    
    // 집게로 인형을 집어 들어올린다
    public int pickDoll(int[][] board, int move) {
        int doll = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][move] != 0) {
                doll = board[i][move];
                board[i][move] = 0;
                break;
            }
        }
        
        return doll;
    }
}