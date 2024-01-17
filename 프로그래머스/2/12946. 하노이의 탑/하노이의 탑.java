import java.util.*;

class Solution {
    static ArrayList<int[]> moves;
    public int[][] solution(int n) {
        moves = new ArrayList<>();
        makeHanoiTower(n, 1, 3, 2);
        
        return moves.toArray(new int[moves.size()][2]);
    }
    
    public void makeHanoiTower(int n, int start, int end, int mid) {
        if (n > 0) {
            makeHanoiTower(n - 1, start, mid, end);
            moves.add(new int[]{start, end});
            makeHanoiTower(n - 1, mid, end, start);
        }
    }
}