import java.util.*;

class Solution {
    int row, col;
    
    public boolean isRangeWithin(int x, int y) {
        return Math.abs(x) <= col && Math.abs(y) <= row;
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        col = board[0] / 2;
        row = board[1] / 2;
        int xPos = 0;
        int yPos = 0;
        
        Map<String, Integer> keys = new HashMap<>();
        keys.put("up", 0);
        keys.put("down", 1);
        keys.put("left", 2);
        keys.put("right", 3);
        
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        for (String k : keyinput) {
            int idx = keys.get(k);
            
            int nX = xPos + dx[idx];
            int nY = yPos + dy[idx];
            
            if (isRangeWithin(nX, nY)) {
                xPos = nX;
                yPos = nY;
            }
        }
        
        return new int[]{xPos, yPos};
    }
}