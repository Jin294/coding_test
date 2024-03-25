class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String target = board[h][w];
        
        for (int i = 0; i < 4; i++) {
            int nr = h + dy[i];
            int nc = w + dx[i];
            
            if (isWithinRange(nr, nc, board.length) && target.equals(board[nr][nc])) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isWithinRange(int h, int w, int len) {
        return h >= 0 && w >= 0 && h < len && w < len;
    }
}