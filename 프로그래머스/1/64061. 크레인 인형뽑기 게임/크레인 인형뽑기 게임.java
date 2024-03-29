import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        // 스택으로 바구니 구현
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            int pick = pickDoll(board, move - 1);

            if (pick != 0) {
                // 같은 모양의 인형들이 바구니에서 만나면 터진다
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